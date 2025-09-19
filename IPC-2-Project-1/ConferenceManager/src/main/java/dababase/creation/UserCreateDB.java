package dababase.creation;

import backend.user.User;
import dababase.DBConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase UserCreateDB es la clase encargada de
 *
 * @author YmCris
 * @since Sep 18, 2025
 */
public class UserCreateDB {

    // CONSTANTES -------------------------------------------------
    private static final String SQL_INSERT_USER
            = "INSERT INTO user (user_name, password, dpi, phone_number, institution_name, email, photo, is_foreign, active) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_USER_EXISTENCE = "SELECT * FROM user WHERE dpi = ?";
    private static final String SQL_GET_USERS = "SELECT * FROM user ";
    //private static final String SQL_EDIT_USER = "UPDATE user set name = ?, phoneNumber = ?, email = ? , password = ? WHERE codigo = ?";

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void createUser(User user) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(SQL_INSERT_USER)) {
            insert.setString(1, user.getName());
            insert.setString(2, user.getPassword());
            insert.setString(3, user.getDpi());
            insert.setString(4, user.getPhoneNumber());
            insert.setString(5, user.getInstitutionName());
            insert.setString(6, user.getEmail());
            insert.setBlob(7,InputStream.nullInputStream());
            insert.setBoolean(8, user.isForeign());
            insert.setBoolean(9, user.isActive());
            insert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al crear el usuario en la base de datos porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean userExist(String dpi) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(SQL_GET_USER_EXISTENCE);) {
            query.setString(1, dpi);
            ResultSet result = query.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al ver si existe el usuario porque " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    /*
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>(10);
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(SQL_GET_USERS);) {
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("dpi"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("photo"),
                        resultSet.getString("insititutionName"),
                        resultSet.getBoolean("foreign"),
                        resultSet.getBoolean("active")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la consulta de usuraios porque " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    public Optional<User> getUser(String dpi) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement query = connection.prepareStatement(SQL_GET_USER_EXISTENCE);) {
            query.setString(1, dpi);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("dpi"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("photo"),
                        resultSet.getString("insititutionName"),
                        resultSet.getBoolean("foreign"),
                        resultSet.getBoolean("active")
                );
                return Optional.of(user);
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al obtener al usuario por su dpi porque " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void editUser(User user) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement insert = connection.prepareStatement(SQL_EDIT_USER);) {
            insert.setString(1, user.getName());
            insert.setString(2, user.getDpi());
            insert.setString(3, user.getPhoneNumber());
            insert.setString(4, user.getEmail());
            insert.setString(5, user.getPassword());
            insert.setString(6, user.getPhoto());
            insert.setString(7, user.getInstitutionName());
            insert.setBoolean(8, user.isForeign());
            insert.setBoolean(9, user.isActive());
            insert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al actualizar el usuario " + e.getMessage());
            e.printStackTrace();
        }
    }
     */
}
