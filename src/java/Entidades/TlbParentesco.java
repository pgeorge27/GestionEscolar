/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author georgeperez
 */
@Entity
@Table(name = "tlb_parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlbParentesco.findAll", query = "SELECT t FROM TlbParentesco t"),
    @NamedQuery(name = "TlbParentesco.findByIdParentesco", query = "SELECT t FROM TlbParentesco t WHERE t.idParentesco = :idParentesco"),
    @NamedQuery(name = "TlbParentesco.findByNombre", query = "SELECT t FROM TlbParentesco t WHERE t.nombre = :nombre")})
public class TlbParentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parentesco")
    private Integer idParentesco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParentesco")
    private List<TblAutorizado> tblAutorizadoList;

    public TlbParentesco() {
    }

    public TlbParentesco(Integer idParentesco) {
        this.idParentesco = idParentesco;
    }

    public TlbParentesco(Integer idParentesco, String nombre) {
        this.idParentesco = idParentesco;
        this.nombre = nombre;
    }

    public Integer getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Integer idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<TblAutorizado> getTblAutorizadoList() {
        return tblAutorizadoList;
    }

    public void setTblAutorizadoList(List<TblAutorizado> tblAutorizadoList) {
        this.tblAutorizadoList = tblAutorizadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParentesco != null ? idParentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlbParentesco)) {
            return false;
        }
        TlbParentesco other = (TlbParentesco) object;
        if ((this.idParentesco == null && other.idParentesco != null) || (this.idParentesco != null && !this.idParentesco.equals(other.idParentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
