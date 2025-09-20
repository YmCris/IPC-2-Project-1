package dababase.queries;

import backend.user.User;
import dababase.DBConnection;
import dababase.creation.UserCreateDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase SystemAdminsDB es la clase encargada de hacer la consulta hacia la base
 * de datos de la tabla de administradores de usuarios.
 *
 * @author YmCris
 * @since Sep 19, 2025
 */
public class SystemAdminsDB {

    // CONSTANTES -------------------------------------------------
    private static final String SQL_INSERT_SYSTEM_ADMIN = "INSERT INTO system_admins (user_dpi) VALUES (?)";
    private static final String SQL_GET_SYSTEM_ADMIN_EXISTENCE = "SELECT * FROM user WHERE dpi = ?";
    private static final String SQL_GET_SYSTEM_ADMINS = "SELECT * FROM system_admins ";
    private static final String SQL_DELETE_SYSTEM_ADMIN = "DELETE FROM system_admins WHERE dpi = ?";

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void createSystemAdmin(User user) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(SQL_INSERT_SYSTEM_ADMIN)) {
            insert.setString(1, user.getDpi());
            insert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al crear un admin del sistema en la base de datos porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean systemAdminExist(String dpi) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(SQL_GET_SYSTEM_ADMIN_EXISTENCE);) {
            query.setString(1, dpi);
            ResultSet result = query.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al ver si existe el system admin porque " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getSystemAdmins() {
        ArrayList<User> users = new ArrayList<>(5);
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(SQL_GET_SYSTEM_ADMINS);) {
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                String dpi = resultSet.getString("dpi");
                UserCreateDB userdb = new UserCreateDB();
                User user = userdb.getUser(dpi);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la consulta de systeam admins porque " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    public void deleteSystemAdmin(User user) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(SQL_DELETE_SYSTEM_ADMIN);) {
            insert.setString(1, user.getDpi());
            insert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al eliminar el system admin" + e.getMessage());
            e.printStackTrace();
        }
    }
}
