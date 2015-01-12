/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author indra
 */
@Entity
@Table(name = "tbl_estudiante_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstudianteCursos.findAll", query = "SELECT t FROM TblEstudianteCursos t"),
    @NamedQuery(name = "TblEstudianteCursos.findByIdEstudianteCursos", query = "SELECT t FROM TblEstudianteCursos t WHERE t.idEstudianteCursos = :idEstudianteCursos")})
public class TblEstudianteCursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante_cursos")
    private Integer idEstudianteCursos;
    @JoinColumn(name = "id_cursos", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private TblCursos idCursos;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false)
    private TblEstudiante idEstudiante;

    public TblEstudianteCursos() {
    }

    public TblEstudianteCursos(Integer idEstudianteCursos) {
        this.idEstudianteCursos = idEstudianteCursos;
    }

    public Integer getIdEstudianteCursos() {
        return idEstudianteCursos;
    }

    public void setIdEstudianteCursos(Integer idEstudianteCursos) {
        this.idEstudianteCursos = idEstudianteCursos;
    }

    public TblCursos getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(TblCursos idCursos) {
        this.idCursos = idCursos;
    }

    public TblEstudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(TblEstudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudianteCursos != null ? idEstudianteCursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstudianteCursos)) {
            return false;
        }
        TblEstudianteCursos other = (TblEstudianteCursos) object;
        if ((this.idEstudianteCursos == null && other.idEstudianteCursos != null) || (this.idEstudianteCursos != null && !this.idEstudianteCursos.equals(other.idEstudianteCursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblEstudianteCursos[ idEstudianteCursos=" + idEstudianteCursos + " ]";
    }
    
}
