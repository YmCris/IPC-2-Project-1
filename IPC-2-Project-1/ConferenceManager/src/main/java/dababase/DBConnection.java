package dababase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Clase DBConnection es la clase encargada de crear la única conexión a la base
 * de datos y de tener las otras clases relacionadas a la base de datos
 *
 * @author YmCris
 * @since Sep 17, 2025
 */
public class DBConnection {

    // CONSTANTES --------------------------------------------------------------
    private static final int PUERTO = 3306;
    private static final String IP = "localhost";
    private static final String PASSWORD = "12345";
    private static final String USER_NAME = "crisadmndb";
    private static final String SCHEMA = "conference_manager";
    private static final String URL
            = "jdbc:mysql://localhost:3306/conference_manager"
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Connection connection;
    private static DBConnection instance;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Se ha creado la conexión a la base de datos");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la conexión a la base de datos porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear y utilizar la única instancia existe en el
     * programa durante su ejecución.
     *
     * @return instance - instancia con la cual se puede acceder a la connection
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // GETTERS -----------------------------------------------------------------
    public Connection getConnection() {
        return connection;
    }

}
