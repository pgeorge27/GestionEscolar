/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author georgeperez
 */
@Entity
@Table(name = "tbl_representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRepresentante.findAll", query = "SELECT t FROM TblRepresentante t"),
    @NamedQuery(name = "TblRepresentante.findByIdRepresentante", query = "SELECT t FROM TblRepresentante t WHERE t.idRepresentante = :idRepresentante"),
    @NamedQuery(name = "TblRepresentante.findByApellidos", query = "SELECT t FROM TblRepresentante t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TblRepresentante.findByNombres", query = "SELECT t FROM TblRepresentante t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TblRepresentante.findByEdad", query = "SELECT t FROM TblRepresentante t WHERE t.edad = :edad"),
    @NamedQuery(name = "TblRepresentante.findByEstadoCivil", query = "SELECT t FROM TblRepresentante t WHERE t.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "TblRepresentante.findByCedula", query = "SELECT t FROM TblRepresentante t WHERE t.cedula = :cedula"),
    @NamedQuery(name = "TblRepresentante.findByNacionalidad", query = "SELECT t FROM TblRepresentante t WHERE t.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "TblRepresentante.findByFechNac", query = "SELECT t FROM TblRepresentante t WHERE t.fechNac = :fechNac"),
    @NamedQuery(name = "TblRepresentante.findByDirHab", query = "SELECT t FROM TblRepresentante t WHERE t.dirHab = :dirHab"),
    @NamedQuery(name = "TblRepresentante.findByProfesion", query = "SELECT t FROM TblRepresentante t WHERE t.profesion = :profesion"),
    @NamedQuery(name = "TblRepresentante.findByLugarTrab", query = "SELECT t FROM TblRepresentante t WHERE t.lugarTrab = :lugarTrab"),
    @NamedQuery(name = "TblRepresentante.findByDirTrab", query = "SELECT t FROM TblRepresentante t WHERE t.dirTrab = :dirTrab"),
    @NamedQuery(name = "TblRepresentante.findByTlfTrab", query = "SELECT t FROM TblRepresentante t WHERE t.tlfTrab = :tlfTrab"),
    @NamedQuery(name = "TblRepresentante.findByTlfHab", query = "SELECT t FROM TblRepresentante t WHERE t.tlfHab = :tlfHab"),
    @NamedQuery(name = "TblRepresentante.findByTlfCel", query = "SELECT t FROM TblRepresentante t WHERE t.tlfCel = :tlfCel"),
    @NamedQuery(name = "TblRepresentante.findByFoto", query = "SELECT t FROM TblRepresentante t WHERE t.foto = :foto")})
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
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_nac")
    @Temporal(TemporalType.DATE)
    private Date fechNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dir_hab")
    private String dirHab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "profesion")
    private String profesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "lugar_trab")
    private String lugarTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dir_trab")
    private String dirTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_trab")
    private String tlfTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_hab")
    private String tlfHab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_cel")
    private String tlfCel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRepresentanteM")
    private List<TblEstudiante> tblEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRepresentanteP")
    private List<TblEstudiante> tblEstudianteList1;

    public TblRepresentante() {
        this.foto = "none.jpg";
    }

    public TblRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public TblRepresentante(Integer idRepresentante, String apellidos, String nombres, int edad, String estadoCivil, String cedula, String nacionalidad, Date fechNac, String dirHab, String profesion, String lugarTrab, String dirTrab, String tlfTrab, String tlfHab, String tlfCel, String foto) {
        this.idRepresentante = idRepresentante;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.fechNac = fechNac;
        this.dirHab = dirHab;
        this.profesion = profesion;
        this.lugarTrab = lugarTrab;
        this.dirTrab = dirTrab;
        this.tlfTrab = tlfTrab;
        this.tlfHab = tlfHab;
        this.tlfCel = tlfCel;
        this.foto = foto;
    }

    public Integer getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechNac() {
        return fechNac;
    }

    public void setFechNac(Date fechNac) {
        this.fechNac = fechNac;
    }

    public String getDirHab() {
        return dirHab;
    }

    public void setDirHab(String dirHab) {
        this.dirHab = dirHab;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLugarTrab() {
        return lugarTrab;
    }

    public void setLugarTrab(String lugarTrab) {
        this.lugarTrab = lugarTrab;
    }

    public String getDirTrab() {
        return dirTrab;
    }

    public void setDirTrab(String dirTrab) {
        this.dirTrab = dirTrab;
    }

    public String getTlfTrab() {
        return tlfTrab;
    }

    public void setTlfTrab(String tlfTrab) {
        this.tlfTrab = tlfTrab;
    }

    public String getTlfHab() {
        return tlfHab;
    }

    public void setTlfHab(String tlfHab) {
        this.tlfHab = tlfHab;
    }

    public String getTlfCel() {
        return tlfCel;
    }

    public void setTlfCel(String tlfCel) {
        this.tlfCel = tlfCel;
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

    @XmlTransient
    public List<TblEstudiante> getTblEstudianteList1() {
        return tblEstudianteList1;
    }

    public void setTblEstudianteList1(List<TblEstudiante> tblEstudianteList1) {
        this.tblEstudianteList1 = tblEstudianteList1;
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
