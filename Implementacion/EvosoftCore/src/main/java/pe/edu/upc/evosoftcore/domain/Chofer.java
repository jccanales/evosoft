/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jean Carlo
 */
@Entity
@Table(name = "chofer")
public class Chofer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchofer")
    private Integer idChofer;
    @JoinColumn(name = "idLicencia", referencedColumnName = "idLicencia")
    @OneToOne(optional = false)
    private Licencia idLicencia = new Licencia();
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private Integer telefono;

    public Integer getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(Integer idChofer) {
        this.idChofer = idChofer;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Licencia getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Licencia idLicencia) {
        this.idLicencia = idLicencia;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.evosoftcore.domain.Chofer[ idChofer=" + idChofer + " ]";
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChofer != null ? idChofer.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chofer)) {
            return false;
        }
        Chofer other = (Chofer) object;
        if ((this.idChofer == null && other.idChofer != null) || (this.idChofer != null && !this.idChofer.equals(other.idChofer))) {
            return false;
        }
        return true;
    }

}
