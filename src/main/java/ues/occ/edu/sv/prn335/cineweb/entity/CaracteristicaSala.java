/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fatycalderon
 */
@Entity
@Table(name = "caracteristica_sala")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaSala.findAll", query = "SELECT c FROM CaracteristicaSala c"),
    @NamedQuery(name = "CaracteristicaSala.findByIdCaracteristica", query = "SELECT c FROM CaracteristicaSala c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "CaracteristicaSala.findByCaracteristica", query = "SELECT c FROM CaracteristicaSala c WHERE c.caracteristica = :caracteristica"),
    @NamedQuery(name = "CaracteristicaSala.findByDescripcion", query = "SELECT c FROM CaracteristicaSala c WHERE c.descripcion = :descripcion")})
public class CaracteristicaSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caracteristica")
    private Integer idCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaSala")
    private Collection<AtributoSala> atributoSalaCollection;

    public CaracteristicaSala() {
    }

    public CaracteristicaSala(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public CaracteristicaSala(Integer idCaracteristica, String caracteristica, String descripcion) {
        this.idCaracteristica = idCaracteristica;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<AtributoSala> getAtributoSalaCollection() {
        return atributoSalaCollection;
    }

    public void setAtributoSalaCollection(Collection<AtributoSala> atributoSalaCollection) {
        this.atributoSalaCollection = atributoSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaSala)) {
            return false;
        }
        CaracteristicaSala other = (CaracteristicaSala) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.CaracteristicaSala[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
