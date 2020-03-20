package beans;

import com.mycompany.project_to2.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ele
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    public List<Users> getClients() throws ClassNotFoundException, SQLException {
        Connection connect = null;
        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
        }
        List<Users> clients = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("SELECT ID_client, name, dni,  password, address, admin FROM users");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Users user = new Users();
            user.setIDclient(rs.getInt("ID_client"));
            user.setName(rs.getString("name"));
            user.setDni(rs.getString("dni"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            user.setAdmin(rs.getBoolean("admin"));
            //load all users into clients
            clients.add(user);
        }
        // close resources
        rs.close();
        pstmt.close();
        connect.close();
        return clients;
    }
    public void checkUser(){
        
        
    }
}
