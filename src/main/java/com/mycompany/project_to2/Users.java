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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ele
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIDclient", query = "SELECT u FROM Users u WHERE u.iDclient = :iDclient"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByDni", query = "SELECT u FROM Users u WHERE u.dni = :dni"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address"),
    @NamedQuery(name = "Users.findByAdmin", query = "SELECT u FROM Users u WHERE u.admin = :admin")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_client")
    private Integer iDclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin")
    private boolean admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDclient")
    private Collection<ClientInvoices> clientInvoicesCollection;

    public Users() {
    }

    public Users(Integer iDclient) {
        this.iDclient = iDclient;
    }

    public Users(Integer iDclient, String name, String dni, String password, String address, boolean admin) {
        this.iDclient = iDclient;
        this.name = name;
        this.dni = dni;
        this.password = password;
        this.address = address;
        this.admin = admin;
    }

    public Integer getIDclient() {
        return iDclient;
    }

    public void setIDclient(Integer iDclient) {
        this.iDclient = iDclient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
        hash += (iDclient != null ? iDclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iDclient == null && other.iDclient != null) || (this.iDclient != null && !this.iDclient.equals(other.iDclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project_to2.Users[ iDclient=" + iDclient + " ]";
    }
    
}
