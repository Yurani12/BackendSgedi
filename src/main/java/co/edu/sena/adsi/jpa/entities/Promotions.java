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
@Table(name = "promotions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p")
    , @NamedQuery(name = "Promotions.findById", query = "SELECT p FROM Promotions p WHERE p.id = :id")
    , @NamedQuery(name = "Promotions.findByPromotionName", query = "SELECT p FROM Promotions p WHERE p.promotionName = :promotionName")
    , @NamedQuery(name = "Promotions.findByDiscount", query = "SELECT p FROM Promotions p WHERE p.discount = :discount")
    , @NamedQuery(name = "Promotions.findByPromotionStart", query = "SELECT p FROM Promotions p WHERE p.promotionStart = :promotionStart")
    , @NamedQuery(name = "Promotions.findByPromotionEnd", query = "SELECT p FROM Promotions p WHERE p.promotionEnd = :promotionEnd")})
public class Promotions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "promotion_name")
    private String promotionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private double discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "promotion_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "promotion_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionEnd;
    @JoinColumn(name = "id_packages", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Packages idPackages;

    public Promotions() {
    }

    public Promotions(Integer id) {
        this.id = id;
    }

    public Promotions(Integer id, String promotionName, double discount, Date promotionStart, Date promotionEnd) {
        this.id = id;
        this.promotionName = promotionName;
        this.discount = discount;
        this.promotionStart = promotionStart;
        this.promotionEnd = promotionEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getPromotionStart() {
        return promotionStart;
    }

    public void setPromotionStart(Date promotionStart) {
        this.promotionStart = promotionStart;
    }

    public Date getPromotionEnd() {
        return promotionEnd;
    }

    public void setPromotionEnd(Date promotionEnd) {
        this.promotionEnd = promotionEnd;
    }

    public Packages getIdPackages() {
        return idPackages;
    }

    public void setIdPackages(Packages idPackages) {
        this.idPackages = idPackages;
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
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Promotions[ id=" + id + " ]";
    }
    
}
