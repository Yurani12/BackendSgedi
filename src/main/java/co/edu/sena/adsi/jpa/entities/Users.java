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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findByTelephone", query = "SELECT u FROM Users u WHERE u.telephone = :telephone")
    , @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address")
    , @NamedQuery(name = "Users.findByOccupation", query = "SELECT u FROM Users u WHERE u.occupation = :occupation")
    , @NamedQuery(name = "Users.findBySex", query = "SELECT u FROM Users u WHERE u.sex = :sex")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByNumDocument", query = "SELECT u FROM Users u WHERE u.numDocument = :numDocument")
    , @NamedQuery(name = "Users.findByActive", query = "SELECT u FROM Users u WHERE u.active = :active")
    , @NamedQuery(name = "Users.findByUlrImg", query = "SELECT u FROM Users u WHERE u.ulrImg = :ulrImg")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephone")
    private int telephone;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sex")
    private String sex;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_document")
    private String numDocument;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 150)
    @Column(name = "ulr_img")
    private String ulrImg;
    
    @JoinTable(name = "users_has_rol", joinColumns = {
        @JoinColumn(name = "id_users", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id")})
    @ManyToMany
    private List<Rol> rolList;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Documents> documentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Formalities> formalitiesList;
    @JoinColumn(name = "id_cities", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cities Cities;
    @JoinColumn(name = "id_documents_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsType DocumentsType;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String lastName, String name, int telephone, String sex, String email, String password, String numDocument, boolean active) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.telephone = telephone;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.numDocument = numDocument;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUlrImg() {
        return ulrImg;
    }

    public void setUlrImg(String ulrImg) {
        this.ulrImg = ulrImg;
    }
    
    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
    
    @XmlTransient
    public List<Documents> getDocumentsList() {
        return documentsList;
    }

    public void setDocumentsList(List<Documents> documentsList) {
        this.documentsList = documentsList;
    }
    
    @XmlTransient
    public List<Formalities> getFormalitiesList() {
        return formalitiesList;
    }

    public void setFormalitiesList(List<Formalities> formalitiesList) {
        this.formalitiesList = formalitiesList;
    }

    public Cities getCities() {
        return Cities;
    }

    public void setCities(Cities Cities) {
        this.Cities = Cities;
    }

    public DocumentsType getDocumentsType() {
        return DocumentsType;
    }

    public void setDocumentsType(DocumentsType DocumentsType) {
        this.DocumentsType = DocumentsType;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Users[ id=" + id + " ]";
    }
    
}
