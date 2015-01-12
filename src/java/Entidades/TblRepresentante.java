/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author indra
 */
@Entity
@Table(name = "tbl_representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRepresentante.findAll", query = "SELECT t FROM TblRepresentante t"),
    @NamedQuery(name = "TblRepresentante.findByIdRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.idRepresentante = :idRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByApellidosRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.apellidosRepresentante = :apellidosRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByNombresRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.nombresRepresentante = :nombresRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByEdadRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.edadRepresentante = :edadRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByEstadoCivilRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.estadoCivilRepresentante = :estadoCivilRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByCedulaRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.cedulaRepresentante = :cedulaRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByNacionalidadRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.nacionalidadRepresentante = :nacionalidadRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByFechNacRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.fechNacRepresentante = :fechNacRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByDirHabRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.dirHabRepresentante = :dirHabRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByProfesionRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.profesionRepresentante = :profesionRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByLugarTrabRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.lugarTrabRepresentante = :lugarTrabRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByDirTrabRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.dirTrabRepresentante = :dirTrabRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByTlfTrabRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.tlfTrabRepresentante = :tlfTrabRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByTlfHabRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.tlfHabRepresentante = :tlfHabRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByTlfCelRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.tlfCelRepresentante = :tlfCelRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByFotoRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.fotoRepresentante = :fotoRepresentante")})
public class TblRepresentante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_representante")
    private Integer idRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apellidos_representante")
    private String apellidosRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombres_representante")
    private String nombresRepresentante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_representante")
    private int edadRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado_civil_representante")
    private String estadoCivilRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula_representante")
    private String cedulaRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nacionalidad_representante")
    private String nacionalidadRepresentante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_nac_representante")
    @Temporal(TemporalType.DATE)
    private Date fechNacRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dir_hab_representante")
    private String dirHabRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "profesion_representante")
    private String profesionRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "lugar_trab_representante")
    private String lugarTrabRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dir_trab_representante")
    private String dirTrabRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_trab_representante")
    private String tlfTrabRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_hab_representante")
    private String tlfHabRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_cel_representante")
    private String tlfCelRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "foto_representante")
    private String fotoRepresentante;
    @JoinColumn(name = "parentesco", referencedColumnName = "id_parentesco")
    @ManyToOne(optional = false)
    private TlbParentesco parentesco;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false)
    private TblEstudiante idEstudiante;

    public TblRepresentante() {
    }

    public TblRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public TblRepresentante(Integer idRepresentante, String apellidosRepresentante, String nombresRepresentante, int edadRepresentante, String estadoCivilRepresentante, String cedulaRepresentante, String nacionalidadRepresentante, Date fechNacRepresentante, String dirHabRepresentante, String profesionRepresentante, String lugarTrabRepresentante, String dirTrabRepresentante, String tlfTrabRepresentante, String tlfHabRepresentante, String tlfCelRepresentante, String fotoRepresentante) {
        this.idRepresentante = idRepresentante;
        this.apellidosRepresentante = apellidosRepresentante;
        this.nombresRepresentante = nombresRepresentante;
        this.edadRepresentante = edadRepresentante;
        this.estadoCivilRepresentante = estadoCivilRepresentante;
        this.cedulaRepresentante = cedulaRepresentante;
        this.nacionalidadRepresentante = nacionalidadRepresentante;
        this.fechNacRepresentante = fechNacRepresentante;
        this.dirHabRepresentante = dirHabRepresentante;
        this.profesionRepresentante = profesionRepresentante;
        this.lugarTrabRepresentante = lugarTrabRepresentante;
        this.dirTrabRepresentante = dirTrabRepresentante;
        this.tlfTrabRepresentante = tlfTrabRepresentante;
        this.tlfHabRepresentante = tlfHabRepresentante;
        this.tlfCelRepresentante = tlfCelRepresentante;
        this.fotoRepresentante = fotoRepresentante;
    }

    public Integer getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getApellidosRepresentante() {
        return apellidosRepresentante;
    }

    public void setApellidosRepresentante(String apellidosRepresentante) {
        this.apellidosRepresentante = apellidosRepresentante;
    }

    public String getNombresRepresentante() {
        return nombresRepresentante;
    }

    public void setNombresRepresentante(String nombresRepresentante) {
        this.nombresRepresentante = nombresRepresentante;
    }

    public int getEdadRepresentante() {
        return edadRepresentante;
    }

    public void setEdadRepresentante(int edadRepresentante) {
        this.edadRepresentante = edadRepresentante;
    }

    public String getEstadoCivilRepresentante() {
        return estadoCivilRepresentante;
    }

    public void setEstadoCivilRepresentante(String estadoCivilRepresentante) {
        this.estadoCivilRepresentante = estadoCivilRepresentante;
    }

    public String getCedulaRepresentante() {
        return cedulaRepresentante;
    }

    public void setCedulaRepresentante(String cedulaRepresentante) {
        this.cedulaRepresentante = cedulaRepresentante;
    }

    public String getNacionalidadRepresentante() {
        return nacionalidadRepresentante;
    }

    public void setNacionalidadRepresentante(String nacionalidadRepresentante) {
        this.nacionalidadRepresentante = nacionalidadRepresentante;
    }

    public Date getFechNacRepresentante() {
        return fechNacRepresentante;
    }

    public void setFechNacRepresentante(Date fechNacRepresentante) {
        this.fechNacRepresentante = fechNacRepresentante;
    }

    public String getDirHabRepresentante() {
        return dirHabRepresentante;
    }

    public void setDirHabRepresentante(String dirHabRepresentante) {
        this.dirHabRepresentante = dirHabRepresentante;
    }

    public String getProfesionRepresentante() {
        return profesionRepresentante;
    }

    public void setProfesionRepresentante(String profesionRepresentante) {
        this.profesionRepresentante = profesionRepresentante;
    }

    public String getLugarTrabRepresentante() {
        return lugarTrabRepresentante;
    }

    public void setLugarTrabRepresentante(String lugarTrabRepresentante) {
        this.lugarTrabRepresentante = lugarTrabRepresentante;
    }

    public String getDirTrabRepresentante() {
        return dirTrabRepresentante;
    }

    public void setDirTrabRepresentante(String dirTrabRepresentante) {
        this.dirTrabRepresentante = dirTrabRepresentante;
    }

    public String getTlfTrabRepresentante() {
        return tlfTrabRepresentante;
    }

    public void setTlfTrabRepresentante(String tlfTrabRepresentante) {
        this.tlfTrabRepresentante = tlfTrabRepresentante;
    }

    public String getTlfHabRepresentante() {
        return tlfHabRepresentante;
    }

    public void setTlfHabRepresentante(String tlfHabRepresentante) {
        this.tlfHabRepresentante = tlfHabRepresentante;
    }

    public String getTlfCelRepresentante() {
        return tlfCelRepresentante;
    }

    public void setTlfCelRepresentante(String tlfCelRepresentante) {
        this.tlfCelRepresentante = tlfCelRepresentante;
    }

    public String getFotoRepresentante() {
        return fotoRepresentante;
    }

    public void setFotoRepresentante(String fotoRepresentante) {
        this.fotoRepresentante = fotoRepresentante;
    }

    public TlbParentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(TlbParentesco parentesco) {
        this.parentesco = parentesco;
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
        hash += (idRepresentante != null ? idRepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRepresentante)) {
            return false;
        }
        TblRepresentante other = (TblRepresentante) object;
        if ((this.idRepresentante == null && other.idRepresentante != null) || (this.idRepresentante != null && !this.idRepresentante.equals(other.idRepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblRepresentante[ idRepresentante=" + idRepresentante + " ]";
    }
    
}
