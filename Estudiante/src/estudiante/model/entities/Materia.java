/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CARITO
 */
@Entity
@Table(name = "MATERIA")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Materia.findByDescripcion", query = "SELECT m FROM Materia m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Materia.findByConsecutiva", query = "SELECT m FROM Materia m WHERE m.consecutiva = :consecutiva")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MATERIA", nullable = false, precision = 38, scale = 0)
    private BigDecimal idMateria;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "CONSECUTIVA", nullable = false)
    private BigInteger consecutiva;
    @OneToMany(mappedBy = "idMateria")
    private List<Matricula> matriculaList;

    public Materia() {
    }

    public Materia(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(BigDecimal idMateria, String nombre, String descripcion, BigInteger consecutiva) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consecutiva = consecutiva;
    }

    public BigDecimal getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getConsecutiva() {
        return consecutiva;
    }

    public void setConsecutiva(BigInteger consecutiva) {
        this.consecutiva = consecutiva;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "estudiante.model.entities.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
