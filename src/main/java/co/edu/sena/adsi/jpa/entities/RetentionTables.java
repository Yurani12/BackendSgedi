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
@Table(name = "retention_tables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetentionTables.findAll", query = "SELECT r FROM RetentionTables r")
    , @NamedQuery(name = "RetentionTables.findById", query = "SELECT r FROM RetentionTables r WHERE r.id = :id")
    , @NamedQuery(name = "RetentionTables.findBySerie", query = "SELECT r FROM RetentionTables r WHERE r.serie = :serie")
    , @NamedQuery(name = "RetentionTables.findBySubSerie", query = "SELECT r FROM RetentionTables r WHERE r.subSerie = :subSerie")
    , @NamedQuery(name = "RetentionTables.findByDocumentType", query = "SELECT r FROM RetentionTables r WHERE r.documentType = :documentType")
    , @NamedQuery(name = "RetentionTables.findByDate", query = "SELECT r FROM RetentionTables r WHERE r.date = :date")
    , @NamedQuery(name = "RetentionTables.findByTotalConservation", query = "SELECT r FROM RetentionTables r WHERE r.totalConservation = :totalConservation")
    , @NamedQuery(name = "RetentionTables.findByProcedimet", query = "SELECT r FROM RetentionTables r WHERE r.procedimet = :procedimet")})
public class RetentionTables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sub_serie")
    private String subSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_type")
    private String documentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_conservation")
    private String totalConservation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "procedimet")
    private String procedimet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRetentionTables")
    private List<DocumentsHasState> documentsHasStateList;

    public RetentionTables() {
    }

    public RetentionTables(Integer id) {
        this.id = id;
    }

    public RetentionTables(Integer id, String serie, String subSerie, String documentType, Date date, String totalConservation, String procedimet) {
        this.id = id;
        this.serie = serie;
        this.subSerie = subSerie;
        this.documentType = documentType;
        this.date = date;
        this.totalConservation = totalConservation;
        this.procedimet = procedimet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubSerie() {
        return subSerie;
    }

    public void setSubSerie(String subSerie) {
        this.subSerie = subSerie;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalConservation() {
        return totalConservation;
    }

    public void setTotalConservation(String totalConservation) {
        this.totalConservation = totalConservation;
    }

    public String getProcedimet() {
        return procedimet;
    }

    public void setProcedimet(String procedimet) {
        this.procedimet = procedimet;
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
        if (!(object instanceof RetentionTables)) {
            return false;
        }
        RetentionTables other = (RetentionTables) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.RetentionTables[ id=" + id + " ]";
    }
    
}
