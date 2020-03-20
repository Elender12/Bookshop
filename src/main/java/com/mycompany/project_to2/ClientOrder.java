/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project_to2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ele
 */
@Entity
@Table(name = "client_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientOrder.findAll", query = "SELECT c FROM ClientOrder c"),
    @NamedQuery(name = "ClientOrder.findByIDorder", query = "SELECT c FROM ClientOrder c WHERE c.iDorder = :iDorder"),
    @NamedQuery(name = "ClientOrder.findByQuantity", query = "SELECT c FROM ClientOrder c WHERE c.quantity = :quantity")})
public class ClientOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_order")
    private Integer iDorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    @ManyToOne(optional = false)
    private Products isbn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDorder")
    private Collection<ClientInvoices> clientInvoicesCollection;

    public ClientOrder() {
    }

    public ClientOrder(Integer iDorder) {
        this.iDorder = iDorder;
    }

    public ClientOrder(Integer iDorder, int quantity) {
        this.iDorder = iDorder;
        this.quantity = quantity;
    }

    public Integer getIDorder() {
        return iDorder;
    }

    public void setIDorder(Integer iDorder) {
        this.iDorder = iDorder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getIsbn() {
        return isbn;
    }

    public void setIsbn(Products isbn) {
        this.isbn = isbn;
    }

    @XmlTransient
    public Collection<ClientInvoices> getClientInvoicesCollection() {
        return clientInvoicesCollection;
    }

    public void setClientInvoicesCollection(Collection<ClientInvoices> clientInvoicesCollection) {
        this.clientInvoicesCollection = clientInvoicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDorder != null ? iDorder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientOrder)) {
            return false;
        }
        ClientOrder other = (ClientOrder) object;
        if ((this.iDorder == null && other.iDorder != null) || (this.iDorder != null && !this.iDorder.equals(other.iDorder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project_to2.ClientOrder[ iDorder=" + iDorder + " ]";
    }
    
}
