/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    , @NamedQuery(name = "Company.findByNit", query = "SELECT c FROM Company c WHERE c.nit = :nit")
    , @NamedQuery(name = "Company.findByRazonSocial", query = "SELECT c FROM Company c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "Company.findByNombreComercial", query = "SELECT c FROM Company c WHERE c.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Company.findByDireccion", query = "SELECT c FROM Company c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Company.findByRepresentanteLegal", query = "SELECT c FROM Company c WHERE c.representanteLegal = :representanteLegal")
    , @NamedQuery(name = "Company.findByContacto", query = "SELECT c FROM Company c WHERE c.contacto = :contacto")
    , @NamedQuery(name = "Company.findByExt", query = "SELECT c FROM Company c WHERE c.ext = :ext")
    , @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email")
    , @NamedQuery(name = "Company.findByActive", query = "SELECT c FROM Company c WHERE c.active = :active")
    , @NamedQuery(name = "Company.findByUrlImg", query = "SELECT c FROM Company c WHERE c.urlImg = :urlImg")
    , @NamedQuery(name = "Company.findByPassword", query = "SELECT c FROM Company c WHERE c.password = :password")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private int nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "representante_legal")
    private String representanteLegal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contacto")
    private int contacto;
    @Column(name = "ext")
    private Integer ext;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 150)
    @Column(name = "url_img")
    private String urlImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_cities", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cities idCities;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, int nit, String razonSocial, String nombreComercial, String representanteLegal, int contacto, String email, boolean active, String password) {
        this.id = id;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.representanteLegal = representanteLegal;
        this.contacto = contacto;
        this.email = email;
        this.active = active;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public Integer getExt() {
        return ext;
    }

    public void setExt(Integer ext) {
        this.ext = ext;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cities getIdCities() {
        return idCities;
    }

    public void setIdCities(Cities idCities) {
        this.idCities = idCities;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Company[ id=" + id + " ]";
    }
    
}
