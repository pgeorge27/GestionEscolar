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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author indra
 */
@Entity
@Table(name = "tbl_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMedicamentos.findAll", query = "SELECT t FROM TblMedicamentos t"),
    @NamedQuery(name = "TblMedicamentos.findByIdMedicamentos", query = "SELECT t FROM TblMedicamentos t WHERE t.idMedicamentos = :idMedicamentos"),
    @NamedQuery(name = "TblMedicamentos.findByMedicarFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.medicarFiebre = :medicarFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByCantSuspencionFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.cantSuspencionFiebre = :cantSuspencionFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByCantGotaFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.cantGotaFiebre = :cantGotaFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByCantJarabeFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.cantJarabeFiebre = :cantJarabeFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByCantSupositorioFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.cantSupositorioFiebre = :cantSupositorioFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByPeriodoFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.periodoFiebre = :periodoFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByObservacionFiebre", query = "SELECT t FROM TblMedicamentos t WHERE t.observacionFiebre = :observacionFiebre"),
    @NamedQuery(name = "TblMedicamentos.findByAlergicoPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.alergicoPicadas = :alergicoPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByMedicarPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.medicarPicadas = :medicarPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByCantSuspencionPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.cantSuspencionPicadas = :cantSuspencionPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByCantGotaPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.cantGotaPicadas = :cantGotaPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByCantJarabePicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.cantJarabePicadas = :cantJarabePicadas"),
    @NamedQuery(name = "TblMedicamentos.findByCantSupositorioPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.cantSupositorioPicadas = :cantSupositorioPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByPeriodoPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.periodoPicadas = :periodoPicadas"),
    @NamedQuery(name = "TblMedicamentos.findByObservacionPicadas", query = "SELECT t FROM TblMedicamentos t WHERE t.observacionPicadas = :observacionPicadas")})
public class TblMedicamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamentos")
    private Integer idMedicamentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "medicar_fiebre")
    private String medicarFiebre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_suspencion_fiebre")
    private int cantSuspencionFiebre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_gota_fiebre")
    private int cantGotaFiebre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_jarabe_fiebre")
    private int cantJarabeFiebre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_supositorio_fiebre")
    private int cantSupositorioFiebre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_fiebre")
    private int periodoFiebre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observacion_fiebre")
    private String observacionFiebre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "alergico_picadas")
    private String alergicoPicadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "medicar_picadas")
    private String medicarPicadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_suspencion_picadas")
    private int cantSuspencionPicadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_gota_picadas")
    private int cantGotaPicadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_jarabe_picadas")
    private int cantJarabePicadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_supositorio_picadas")
    private int cantSupositorioPicadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_picadas")
    private int periodoPicadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observacion_picadas")
    private String observacionPicadas;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false)
    private TblEstudiante idEstudiante;

    public TblMedicamentos() {
    }

    public TblMedicamentos(Integer idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public TblMedicamentos(Integer idMedicamentos, String medicarFiebre, int cantSuspencionFiebre, int cantGotaFiebre, int cantJarabeFiebre, int cantSupositorioFiebre, int periodoFiebre, String observacionFiebre, String alergicoPicadas, String medicarPicadas, int cantSuspencionPicadas, int cantGotaPicadas, int cantJarabePicadas, int cantSupositorioPicadas, int periodoPicadas, String observacionPicadas) {
        this.idMedicamentos = idMedicamentos;
        this.medicarFiebre = medicarFiebre;
        this.cantSuspencionFiebre = cantSuspencionFiebre;
        this.cantGotaFiebre = cantGotaFiebre;
        this.cantJarabeFiebre = cantJarabeFiebre;
        this.cantSupositorioFiebre = cantSupositorioFiebre;
        this.periodoFiebre = periodoFiebre;
        this.observacionFiebre = observacionFiebre;
        this.alergicoPicadas = alergicoPicadas;
        this.medicarPicadas = medicarPicadas;
        this.cantSuspencionPicadas = cantSuspencionPicadas;
        this.cantGotaPicadas = cantGotaPicadas;
        this.cantJarabePicadas = cantJarabePicadas;
        this.cantSupositorioPicadas = cantSupositorioPicadas;
        this.periodoPicadas = periodoPicadas;
        this.observacionPicadas = observacionPicadas;
    }

    public Integer getIdMedicamentos() {
        return idMedicamentos;
    }

    public void setIdMedicamentos(Integer idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public String getMedicarFiebre() {
        return medicarFiebre;
    }

    public void setMedicarFiebre(String medicarFiebre) {
        this.medicarFiebre = medicarFiebre;
    }

    public int getCantSuspencionFiebre() {
        return cantSuspencionFiebre;
    }

    public void setCantSuspencionFiebre(int cantSuspencionFiebre) {
        this.cantSuspencionFiebre = cantSuspencionFiebre;
    }

    public int getCantGotaFiebre() {
        return cantGotaFiebre;
    }

    public void setCantGotaFiebre(int cantGotaFiebre) {
        this.cantGotaFiebre = cantGotaFiebre;
    }

    public int getCantJarabeFiebre() {
        return cantJarabeFiebre;
    }

    public void setCantJarabeFiebre(int cantJarabeFiebre) {
        this.cantJarabeFiebre = cantJarabeFiebre;
    }

    public int getCantSupositorioFiebre() {
        return cantSupositorioFiebre;
    }

    public void setCantSupositorioFiebre(int cantSupositorioFiebre) {
        this.cantSupositorioFiebre = cantSupositorioFiebre;
    }

    public int getPeriodoFiebre() {
        return periodoFiebre;
    }

    public void setPeriodoFiebre(int periodoFiebre) {
        this.periodoFiebre = periodoFiebre;
    }

    public String getObservacionFiebre() {
        return observacionFiebre;
    }

    public void setObservacionFiebre(String observacionFiebre) {
        this.observacionFiebre = observacionFiebre;
    }

    public String getAlergicoPicadas() {
        return alergicoPicadas;
    }

    public void setAlergicoPicadas(String alergicoPicadas) {
        this.alergicoPicadas = alergicoPicadas;
    }

    public String getMedicarPicadas() {
        return medicarPicadas;
    }

    public void setMedicarPicadas(String medicarPicadas) {
        this.medicarPicadas = medicarPicadas;
    }

    public int getCantSuspencionPicadas() {
        return cantSuspencionPicadas;
    }

    public void setCantSuspencionPicadas(int cantSuspencionPicadas) {
        this.cantSuspencionPicadas = cantSuspencionPicadas;
    }

    public int getCantGotaPicadas() {
        return cantGotaPicadas;
    }

    public void setCantGotaPicadas(int cantGotaPicadas) {
        this.cantGotaPicadas = cantGotaPicadas;
    }

    public int getCantJarabePicadas() {
        return cantJarabePicadas;
    }

    public void setCantJarabePicadas(int cantJarabePicadas) {
        this.cantJarabePicadas = cantJarabePicadas;
    }

    public int getCantSupositorioPicadas() {
        return cantSupositorioPicadas;
    }

    public void setCantSupositorioPicadas(int cantSupositorioPicadas) {
        this.cantSupositorioPicadas = cantSupositorioPicadas;
    }

    public int getPeriodoPicadas() {
        return periodoPicadas;
    }

    public void setPeriodoPicadas(int periodoPicadas) {
        this.periodoPicadas = periodoPicadas;
    }

    public String getObservacionPicadas() {
        return observacionPicadas;
    }

    public void setObservacionPicadas(String observacionPicadas) {
        this.observacionPicadas = observacionPicadas;
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
        hash += (idMedicamentos != null ? idMedicamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMedicamentos)) {
            return false;
        }
        TblMedicamentos other = (TblMedicamentos) object;
        if ((this.idMedicamentos == null && other.idMedicamentos != null) || (this.idMedicamentos != null && !this.idMedicamentos.equals(other.idMedicamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TblMedicamentos[ idMedicamentos=" + idMedicamentos + " ]";
    }
    
}
