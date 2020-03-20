/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.mycompany.project_to2.Products;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CartBean1 implements Cart {
    String customerName;
    String customerId;
    List<Products> contents;
    @Override
    public void initialize(String person) throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }

        customerId = "0";
        contents = new ArrayList<>();
    }

    @Override
    public void initialize(String person, String id)
                 throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {

            customerName = person;
        }
        contents = new ArrayList<>();
    }


    @Override
    public void addBook(Products book) {
        contents.add(book);
    }
    @Override
    public void removeBook(Products book) throws BookException {
        boolean result = contents.remove(book);
        if (result == false) {
            throw new BookException(book.getTitle() + " not in cart.");
        }
    }
    @Override
    public List<Products> getContents() {
        return contents;
    }

    @Remove
    public void remove() {
        contents = null;
    }

}