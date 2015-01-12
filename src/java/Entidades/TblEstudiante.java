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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author indra
 */
@Entity
@Table(name = "tbl_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstudiante.findAll", query = "SELECT t FROM TblEstudiante t"),
    @NamedQuery(name = "TblEstudiante.findByIdEstudiante", query = "SELECT t FROM TblEstudiante t WHERE t.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "TblEstudiante.findByApellidos", query = "SELECT t FROM TblEstudiante t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TblEstudiante.findByNombres", query = "SELECT t FROM TblEstudiante t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TblEstudiante.findByLugarNac", query = "SELECT t FROM TblEstudiante t WHERE t.lugarNac = :lugarNac"),
    @NamedQuery(name = "TblEstudiante.findByFechNac", query = "SELECT t FROM TblEstudiante t WHERE t.fechNac = :fechNac"),
    @NamedQuery(name = "TblEstudiante.findByEdad", query = "SELECT t FROM TblEstudiante t WHERE t.edad = :edad"),
    @NamedQuery(name = "TblEstudiante.findBySexo", query = "SELECT t FROM TblEstudiante t WHERE t.sexo = :sexo"),
    @NamedQuery(name = "TblEstudiante.findByVacunas", query = "SELECT t FROM TblEstudiante t WHERE t.vacunas = :vacunas"),
    @NamedQuery(name = "TblEstudiante.findByPeso", query = "SELECT t FROM TblEstudiante t WHERE t.peso = :peso"),
    @NamedQuery(name = "TblEstudiante.findByFoto", query = "SELECT t FROM TblEstudiante t WHERE t.foto = :foto"),
    @NamedQuery(name = "TblEstudiante.findByStatus", query = "SELECT t FROM TblEstudiante t WHERE t.status = :status"),
    @NamedQuery(name = "TblEstudiante.findByFechRegistro", query = "SELECT t FROM TblEstudiante t WHERE t.fechRegistro = :fechRegistro")})
public class TblEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
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
    @Size(min = 1, max = 100)
    @Column(name = "lugar_nac")
    private String lugarNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_nac")
    @Temporal(TemporalType.DATE)
    private Date fechNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vacunas")
    private String vacunas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private int peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Column(name = "fech_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private List<TblRepresentante> tblRepresentanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private List<TblMedicamentos> tblMedicamentosList;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private TblNivel idNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private List<TblEstudianteCursos> tblEstudianteCursosList;

    public TblEstudiante() {
    }

    public TblEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public TblEstudiante(Integer idEstudiante, String apellidos, String nombres, String lugarNac, Date fechNac, int edad, String sexo, String vacunas, int peso, String foto, String status) {
        this.idEstudiante = idEstudiante;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.lugarNac = lugarNac;
        this.fechNac = fechNac;
        this.edad = edad;
        this.sexo = sexo;
        this.vacunas = vacunas;
        this.peso = peso;
        this.foto = foto;
        this.status = status;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public Date getFechNac() {
        return fechNac;
    }

    public void setFechNac(Date fechNac) {
        this.fechNac = fechNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechRegistro() {
        return fechRegistro;
    }

    public void setFechRegistro(Date fechRegistro) {
        this.fechRegistro = fechRegistro;
    }

    @XmlTransient
    public List<TblRepresentante> getTblRepresentanteList() {
        return tblRepresentanteList;
    }

    public void setTblRepresentanteList(List<TblRepresentante> tblRepresentanteList) {
        this.tblRepresentanteList = tblRepresentanteList;
    }

    @XmlTransient
    public List<TblMedicamentos> getTblMedicamentosList() {
        return tblMedicamentosList;
    }

    public void setTblMedicamentosList(List<TblMedicamentos> tblMedicamentosList) {
        this.tblMedicamentosList = tblMedicamentosList;
    }

    public TblNivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(TblNivel idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public List<TblEstudianteCursos> getTblEstudianteCursosList() {
        return tblEstudianteCursosList;
    }

    public void setTblEstudianteCursosList(List<TblEstudianteCursos> tblEstudianteCursosList) {
        this.tblEstudianteCursosList = tblEstudianteCursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstudiante)) {
            return false;
        }
        TblEstudiante other = (TblEstudiante) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblEstudiante[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
