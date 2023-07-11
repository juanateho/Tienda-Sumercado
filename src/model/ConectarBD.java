package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author juana
 */
public class ConectarBD {

    private String userDatabase = "root";
    private String passwordDatabase = "MidcourseMirror#201099";
    
    private String nameDatabase = "Sumercado";

    private Connection connection = null;

    public ConectarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + nameDatabase,
                    userDatabase, passwordDatabase);
            if (connection != null) {
                System.out.println("Conexion establecida.");
            }
            System.out.println("");

        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
