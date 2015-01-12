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
import javax.persistence.JoinColumn;
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
 * @author georgeperez
 */
@Entity
@Table(name = "tbl_autorizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAutorizado.findAll", query = "SELECT t FROM TblAutorizado t"),
    @NamedQuery(name = "TblAutorizado.findByIdAutorizado", query = "SELECT t FROM TblAutorizado t WHERE t.idAutorizado = :idAutorizado"),
    @NamedQuery(name = "TblAutorizado.findByNombre", query = "SELECT t FROM TblAutorizado t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblAutorizado.findByApellido", query = "SELECT t FROM TblAutorizado t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "TblAutorizado.findByFoto", query = "SELECT t FROM TblAutorizado t WHERE t.foto = :foto")})
public class TblAutorizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autorizado")
    private Integer idAutorizado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 100)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutorizado")
    private List<TblEstudiante> tblEstudianteList;
    @JoinColumn(name = "id_parentesco", referencedColumnName = "id_parentesco")
    @ManyToOne(optional = false)
    private TlbParentesco idParentesco;

    public TblAutorizado() {
        //idParentesco = new TlbParentesco();
    }

    public TblAutorizado(Integer idAutorizado) {
        this.idAutorizado = idAutorizado;
    }

    public TblAutorizado(Integer idAutorizado, String nombre, String apellido) {
        this.idAutorizado = idAutorizado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdAutorizado() {
        return idAutorizado;
    }

    public void setIdAutorizado(Integer idAutorizado) {
        this.idAutorizado = idAutorizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<TblEstudiante> getTblEstudianteList() {
        return tblEstudianteList;
    }

    public void setTblEstudianteList(List<TblEstudiante> tblEstudianteList) {
        this.tblEstudianteList = tblEstudianteList;
    }

    public TlbParentesco getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(TlbParentesco idParentesco) {
        this.idParentesco = idParentesco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizado != null ? idAutorizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAutorizado)) {
            return false;
        }
        TblAutorizado other = (TblAutorizado) object;
        if ((this.idAutorizado == null && other.idAutorizado != null) || (this.idAutorizado != null && !this.idAutorizado.equals(other.idAutorizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblAutorizado[ idAutorizado=" + idAutorizado + " ]";
    }
    
}
