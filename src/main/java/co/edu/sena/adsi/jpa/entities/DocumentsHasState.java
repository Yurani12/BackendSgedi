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
@Table(name = "documents_has_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsHasState.findAll", query = "SELECT d FROM DocumentsHasState d")
    , @NamedQuery(name = "DocumentsHasState.findByIdDocumentState", query = "SELECT d FROM DocumentsHasState d WHERE d.idDocumentState = :idDocumentState")
    , @NamedQuery(name = "DocumentsHasState.findByDateStart", query = "SELECT d FROM DocumentsHasState d WHERE d.dateStart = :dateStart")
    , @NamedQuery(name = "DocumentsHasState.findByDateEnd", query = "SELECT d FROM DocumentsHasState d WHERE d.dateEnd = :dateEnd")
    , @NamedQuery(name = "DocumentsHasState.findByDescription", query = "SELECT d FROM DocumentsHasState d WHERE d.description = :description")})
public class DocumentsHasState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_document_state")
    private Integer idDocumentState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_documents_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Documents idDocumentsType;
    @JoinColumn(name = "id_retention_tables", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RetentionTables idRetentionTables;
    @JoinColumn(name = "id_state", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private State idState;

    public DocumentsHasState() {
    }

    public DocumentsHasState(Integer idDocumentState) {
        this.idDocumentState = idDocumentState;
    }

    public DocumentsHasState(Integer idDocumentState, Date dateStart, Date dateEnd, String description) {
        this.idDocumentState = idDocumentState;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
    }

    public Integer getIdDocumentState() {
        return idDocumentState;
    }

    public void setIdDocumentState(Integer idDocumentState) {
        this.idDocumentState = idDocumentState;
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

    public Documents getIdDocumentsType() {
        return idDocumentsType;
    }

    public void setIdDocumentsType(Documents idDocumentsType) {
        this.idDocumentsType = idDocumentsType;
    }

    public RetentionTables getIdRetentionTables() {
        return idRetentionTables;
    }

    public void setIdRetentionTables(RetentionTables idRetentionTables) {
        this.idRetentionTables = idRetentionTables;
    }

    public State getIdState() {
        return idState;
    }

    public void setIdState(State idState) {
        this.idState = idState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentState != null ? idDocumentState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsHasState)) {
            return false;
        }
        DocumentsHasState other = (DocumentsHasState) object;
        if ((this.idDocumentState == null && other.idDocumentState != null) || (this.idDocumentState != null && !this.idDocumentState.equals(other.idDocumentState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.DocumentsHasState[ idDocumentState=" + idDocumentState + " ]";
    }
    
}
