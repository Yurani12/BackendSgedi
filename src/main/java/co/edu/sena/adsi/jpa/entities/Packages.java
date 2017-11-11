/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author adsi1261718
 */
@Entity
@Table(name = "packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p")
    , @NamedQuery(name = "Packages.findById", query = "SELECT p FROM Packages p WHERE p.id = :id")
    , @NamedQuery(name = "Packages.findByPackageName", query = "SELECT p FROM Packages p WHERE p.packageName = :packageName")
    , @NamedQuery(name = "Packages.findByPrice", query = "SELECT p FROM Packages p WHERE p.price = :price")
    , @NamedQuery(name = "Packages.findByDurationMonths", query = "SELECT p FROM Packages p WHERE p.durationMonths = :durationMonths")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "package_name")
    private String packageName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration_months")
    private int durationMonths;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPackages")
    private List<Formalities> formalitiesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPackages")
    private List<Promotions> promotionsList;

    public Packages() {
    }

    public Packages(Integer id) {
        this.id = id;
    }

    public Packages(Integer id, String packageName, double price, int durationMonths) {
        this.id = id;
        this.packageName = packageName;
        this.price = price;
        this.durationMonths = durationMonths;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    @XmlTransient
    public List<Formalities> getFormalitiesList() {
        return formalitiesList;
    }

    public void setFormalitiesList(List<Formalities> formalitiesList) {
        this.formalitiesList = formalitiesList;
    }

    @XmlTransient
    public List<Promotions> getPromotionsList() {
        return promotionsList;
    }

    public void setPromotionsList(List<Promotions> promotionsList) {
        this.promotionsList = promotionsList;
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
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Packages[ id=" + id + " ]";
    }
    
}
