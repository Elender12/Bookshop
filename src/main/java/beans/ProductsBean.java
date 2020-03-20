/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.mycompany.project_to2.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import utils.ConnecDB;

/**
 *
 * @author Ele
 */
@Named(value = "productsBean")
@Dependent
public class ProductsBean {

    /**
     * Creates a new instance of ProductsBean
     */
    public ProductsBean() {
    }

    //loads productos
    public List<Products> getProducts() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
          List<Products> books = new ArrayList<>();
        try {
            con = ConnecDB.getConnection();
            ps = con.prepareStatement("SELECT isbn, title, author, content, description, price FROM products;");
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Products book = new Products();
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setContent(rs.getString("content"));
                    book.setDescription(rs.getString("description"));
                    book.setPrice(rs.getFloat("price"));
                    //load all books
                    books.add(book);
                }
            }catch (SQLException ex) {
	System.out.println("Login error -->" + ex.getMessage());
		}finally {
			ConnecDB.close(con);
		}
        return books;
    }
}
