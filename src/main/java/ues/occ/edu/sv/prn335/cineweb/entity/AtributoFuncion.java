/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fatycalderon
 */
@Entity
@Table(name = "atributo_funcion")
@NamedQueries({
    @NamedQuery(name = "AtributoFuncion.findAll", query = "SELECT a FROM AtributoFuncion a"),
    @NamedQuery(name = "AtributoFuncion.findByIdCaracteristica", query = "SELECT a FROM AtributoFuncion a WHERE a.atributoFuncionPK.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "AtributoFuncion.findByIdFuncion", query = "SELECT a FROM AtributoFuncion a WHERE a.atributoFuncionPK.idFuncion = :idFuncion"),
    @NamedQuery(name = "AtributoFuncion.findByValor", query = "SELECT a FROM AtributoFuncion a WHERE a.valor = :valor")})
public class AtributoFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtributoFuncionPK atributoFuncionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id_caracteristica", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracteristicaFuncion caracteristicaFuncion;
    @JoinColumn(name = "id_funcion", referencedColumnName = "id_funcion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcion funcion;

    public AtributoFuncion() {
    }

    public AtributoFuncion(AtributoFuncionPK atributoFuncionPK) {
        this.atributoFuncionPK = atributoFuncionPK;
    }

    public AtributoFuncion(AtributoFuncionPK atributoFuncionPK, int valor) {
        this.atributoFuncionPK = atributoFuncionPK;
        this.valor = valor;
    }

    public AtributoFuncion(int idCaracteristica, int idFuncion) {
        this.atributoFuncionPK = new AtributoFuncionPK(idCaracteristica, idFuncion);
    }

    public AtributoFuncionPK getAtributoFuncionPK() {
        return atributoFuncionPK;
    }

    public void setAtributoFuncionPK(AtributoFuncionPK atributoFuncionPK) {
        this.atributoFuncionPK = atributoFuncionPK;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public CaracteristicaFuncion getCaracteristicaFuncion() {
        return caracteristicaFuncion;
    }

    public void setCaracteristicaFuncion(CaracteristicaFuncion caracteristicaFuncion) {
        this.caracteristicaFuncion = caracteristicaFuncion;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoFuncionPK != null ? atributoFuncionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoFuncion)) {
            return false;
        }
        AtributoFuncion other = (AtributoFuncion) object;
        if ((this.atributoFuncionPK == null && other.atributoFuncionPK != null) || (this.atributoFuncionPK != null && !this.atributoFuncionPK.equals(other.atributoFuncionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.AtributoFuncion[ atributoFuncionPK=" + atributoFuncionPK + " ]";
    }
    
}
