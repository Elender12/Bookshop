package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ele
 */
public class ConnecDB {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        java.sql.Connection connect = null;
        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
            return connect;
        } catch (SQLException ex) {
            Logger.getLogger(ConnecDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

}
