/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author CARITO
 */
@Entity
@Table(name = "MATRICULA")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByNroMatricula", query = "SELECT m FROM Matricula m WHERE m.nroMatricula = :nroMatricula"),
    @NamedQuery(name = "Matricula.findByNivel", query = "SELECT m FROM Matricula m WHERE m.nivel = :nivel"),
    @NamedQuery(name = "Matricula.findByFechaMatriucla", query = "SELECT m FROM Matricula m WHERE m.fechaMatriucla = :fechaMatriucla")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NRO_MATRICULA", nullable = false, precision = 38, scale = 0)
    private BigDecimal nroMatricula;
    @Basic(optional = false)
    @Column(name = "NIVEL", nullable = false, length = 50)
    private String nivel;
    @Basic(optional = false)
    @Column(name = "FECHA_MATRIUCLA", nullable = false, length = 50)
    private String fechaMatriucla;
    @JoinColumn(name = "CEDULA_", referencedColumnName = "CEDULA_")
    @ManyToOne
    private Estudiante cedula;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne
    private Materia idMateria;

    public Matricula() {
    }

    public Matricula(BigDecimal nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public Matricula(BigDecimal nroMatricula, String nivel, String fechaMatriucla) {
        this.nroMatricula = nroMatricula;
        this.nivel = nivel;
        this.fechaMatriucla = fechaMatriucla;
    }

    public BigDecimal getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(BigDecimal nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFechaMatriucla() {
        return fechaMatriucla;
    }

    public void setFechaMatriucla(String fechaMatriucla) {
        this.fechaMatriucla = fechaMatriucla;
    }

    public Estudiante getCedula() {
        return cedula;
    }

    public void setCedula(Estudiante cedula) {
        this.cedula = cedula;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroMatricula != null ? nroMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.nroMatricula == null && other.nroMatricula != null) || (this.nroMatricula != null && !this.nroMatricula.equals(other.nroMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "estudiante.model.entities.Matricula[ nroMatricula=" + nroMatricula + " ]";
    }
    
}
