/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project_to2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ele
 */
@Entity
@Table(name = "client_invoices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientInvoices.findAll", query = "SELECT c FROM ClientInvoices c"),
    @NamedQuery(name = "ClientInvoices.findByIDinvoice", query = "SELECT c FROM ClientInvoices c WHERE c.iDinvoice = :iDinvoice"),
    @NamedQuery(name = "ClientInvoices.findByDateInvoice", query = "SELECT c FROM ClientInvoices c WHERE c.dateInvoice = :dateInvoice")})
public class ClientInvoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_invoice")
    private Integer iDinvoice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_invoice")
    @Temporal(TemporalType.DATE)
    private Date dateInvoice;
    @JoinColumn(name = "ID_client", referencedColumnName = "ID_client")
    @ManyToOne(optional = false)
    private Users iDclient;
    @JoinColumn(name = "ID_order", referencedColumnName = "ID_order")
    @ManyToOne(optional = false)
    private ClientOrder iDorder;

    public ClientInvoices() {
    }

    public ClientInvoices(Integer iDinvoice) {
        this.iDinvoice = iDinvoice;
    }

    public ClientInvoices(Integer iDinvoice, Date dateInvoice) {
        this.iDinvoice = iDinvoice;
        this.dateInvoice = dateInvoice;
    }

    public Integer getIDinvoice() {
        return iDinvoice;
    }

    public void setIDinvoice(Integer iDinvoice) {
        this.iDinvoice = iDinvoice;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Users getIDclient() {
        return iDclient;
    }

    public void setIDclient(Users iDclient) {
        this.iDclient = iDclient;
    }

    public ClientOrder getIDorder() {
        return iDorder;
    }

    public void setIDorder(ClientOrder iDorder) {
        this.iDorder = iDorder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDinvoice != null ? iDinvoice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientInvoices)) {
            return false;
        }
        ClientInvoices other = (ClientInvoices) object;
        if ((this.iDinvoice == null && other.iDinvoice != null) || (this.iDinvoice != null && !this.iDinvoice.equals(other.iDinvoice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project_to2.ClientInvoices[ iDinvoice=" + iDinvoice + " ]";
    }
    
}
