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
 * @author indra
 */
@Entity
@Table(name = "tbl_nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNivel.findAll", query = "SELECT t FROM TblNivel t"),
    @NamedQuery(name = "TblNivel.findByIdNivel", query = "SELECT t FROM TblNivel t WHERE t.idNivel = :idNivel"),
    @NamedQuery(name = "TblNivel.findByNombre", query = "SELECT t FROM TblNivel t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblNivel.findByPrecio", query = "SELECT t FROM TblNivel t WHERE t.precio = :precio")})
public class TblNivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "precio")
    private String precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private List<TblEstudiante> tblEstudianteList;

    public TblNivel() {
    }

    public TblNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public TblNivel(Integer idNivel, String nombre, String precio) {
        this.idNivel = idNivel;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<TblEstudiante> getTblEstudianteList() {
        return tblEstudianteList;
    }

    public void setTblEstudianteList(List<TblEstudiante> tblEstudianteList) {
        this.tblEstudianteList = tblEstudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNivel)) {
            return false;
        }
        TblNivel other = (TblNivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblNivel[ idNivel=" + idNivel + " ]";
    }
    
}
