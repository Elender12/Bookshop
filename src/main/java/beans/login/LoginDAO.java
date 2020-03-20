
package beans.login;

/**
 *
 * @author Ele
 */
import com.mycompany.project_to2.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConnecDB;


public class LoginDAO {

	public static boolean validate(String dni, String password) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnecDB.getConnection();
			ps = con.prepareStatement("SELECT dni, password from users where dni = ? and password = ?");
			ps.setString(1, dni);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
                        
			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error: " + ex.getMessage());
			return false;
		} finally {
			ConnecDB.close(con);
		}
		return false;
	}
        //
        public static Users getUserName(String dni, String password) throws ClassNotFoundException {
       	Connection con = null;
        PreparedStatement ps = null;
		try {
			con = ConnecDB.getConnection();
			ps = con.prepareStatement("SELECT dni, name, password from users where dni = ? and password = ?");
			ps.setString(1, dni);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
                        Users user = new Users();
                       String name = "";
			if (rs.next()) {
                               user.setName(rs.getString("name"));
				return user;
			}
		} catch (SQLException ex) {
			System.out.println("Login error: " + ex.getMessage());
			return null;
		} finally {
			ConnecDB.close(con);
		}
		return null;
        }
         public static boolean isAdmin(String dni, String password) throws ClassNotFoundException {
                        
       	Connection con = null;
        PreparedStatement ps = null;
		try {
			con = ConnecDB.getConnection();
			ps = con.prepareStatement("SELECT dni, admin, password from users where dni = ? and password = ?");
			ps.setString(1, dni);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
                        Users user = new Users();
                        String name = "";
			if (rs.next()) {
                            user.setAdmin(rs.getBoolean("admin"));
                            if(user.getAdmin()){
                                return true;
                            }
			}
		} catch (SQLException ex) {
			System.out.println("Login error: " + ex.getMessage());
			return false;
		} finally {
			ConnecDB.close(con);
		}
		return false;
        }
        
}