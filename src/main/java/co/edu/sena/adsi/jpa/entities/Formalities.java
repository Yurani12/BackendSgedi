/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "formalities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formalities.findAll", query = "SELECT f FROM Formalities f")
    , @NamedQuery(name = "Formalities.findById", query = "SELECT f FROM Formalities f WHERE f.id = :id")
    , @NamedQuery(name = "Formalities.findByDateStart", query = "SELECT f FROM Formalities f WHERE f.dateStart = :dateStart")
    , @NamedQuery(name = "Formalities.findByDateEnd", query = "SELECT f FROM Formalities f WHERE f.dateEnd = :dateEnd")
    , @NamedQuery(name = "Formalities.findByDescription", query = "SELECT f FROM Formalities f WHERE f.description = :description")
    , @NamedQuery(name = "Formalities.findByTotalPrice", query = "SELECT f FROM Formalities f WHERE f.totalPrice = :totalPrice")})
public class Formalities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private Double totalPrice;
    @JoinColumn(name = "id_packages", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Packages idPackages;
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users idUsers;

    public Formalities() {
    }

    public Formalities(Integer id) {
        this.id = id;
    }

    public Formalities(Integer id, Date dateStart) {
        this.id = id;
        this.dateStart = dateStart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Packages getIdPackages() {
        return idPackages;
    }

    public void setIdPackages(Packages idPackages) {
        this.idPackages = idPackages;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formalities)) {
            return false;
        }
        Formalities other = (Formalities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Formalities[ id=" + id + " ]";
    }
    
}
