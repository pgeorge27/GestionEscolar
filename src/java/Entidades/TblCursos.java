/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCursos.findAll", query = "SELECT t FROM TblCursos t"),
    @NamedQuery(name = "TblCursos.findByIdCurso", query = "SELECT t FROM TblCursos t WHERE t.idCurso = :idCurso"),
    @NamedQuery(name = "TblCursos.findByNombre", query = "SELECT t FROM TblCursos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblCursos.findByPrecio", query = "SELECT t FROM TblCursos t WHERE t.precio = :precio")})
public class TblCursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
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
    @ManyToMany(mappedBy = "tblCursosList")
    private List<TblEstudiante> tblEstudianteList;

    public TblCursos() {
    }

    public TblCursos(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public TblCursos(Integer idCurso, String nombre, String precio) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCursos)) {
            return false;
        }
        TblCursos other = (TblCursos) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
