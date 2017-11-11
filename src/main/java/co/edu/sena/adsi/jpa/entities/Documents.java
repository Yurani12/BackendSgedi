/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d")
    , @NamedQuery(name = "Documents.findById", query = "SELECT d FROM Documents d WHERE d.id = :id")
    , @NamedQuery(name = "Documents.findByName", query = "SELECT d FROM Documents d WHERE d.name = :name")
    , @NamedQuery(name = "Documents.findByDescription", query = "SELECT d FROM Documents d WHERE d.description = :description")
    , @NamedQuery(name = "Documents.findByDate", query = "SELECT d FROM Documents d WHERE d.date = :date")
    , @NamedQuery(name = "Documents.findByFormat", query = "SELECT d FROM Documents d WHERE d.format = :format")
    , @NamedQuery(name = "Documents.findByLocation", query = "SELECT d FROM Documents d WHERE d.location = :location")
    , @NamedQuery(name = "Documents.findByFolio", query = "SELECT d FROM Documents d WHERE d.folio = :folio")
    , @NamedQuery(name = "Documents.findByWeight", query = "SELECT d FROM Documents d WHERE d.weight = :weight")
    , @NamedQuery(name = "Documents.findByFile", query = "SELECT d FROM Documents d WHERE d.file = :file")})
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "format")
    private String format;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folio")
    private int folio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private double weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "file")
    private String file;
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users idUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentsType")
    private List<DocumentsHasState> documentsHasStateList;

    public Documents() {
    }

    public Documents(Integer id) {
        this.id = id;
    }

    public Documents(Integer id, String name, String description, Date date, String format, String location, int folio, double weight, String file) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.format = format;
        this.location = location;
        this.folio = folio;
        this.weight = weight;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    @XmlTransient
    public List<DocumentsHasState> getDocumentsHasStateList() {
        return documentsHasStateList;
    }

    public void setDocumentsHasStateList(List<DocumentsHasState> documentsHasStateList) {
        this.documentsHasStateList = documentsHasStateList;
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
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Documents[ id=" + id + " ]";
    }
    
}
