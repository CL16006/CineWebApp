/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "boleto")
@NamedQueries({
    @NamedQuery(name = "Boleto.findAll", query = "SELECT b FROM Boleto b"),
    @NamedQuery(name = "Boleto.findByIdBoleto", query = "SELECT b FROM Boleto b WHERE b.idBoleto = :idBoleto"),
    @NamedQuery(name = "Boleto.findByPrecioBase", query = "SELECT b FROM Boleto b WHERE b.precioBase = :precioBase")})
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_boleto")
    private Integer idBoleto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_base")
    private Double precioBase;
    @JoinTable(name = "boleto_factura", joinColumns = {
        @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")})
    @ManyToMany
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "id_funcion", referencedColumnName = "id_funcion")
    @ManyToOne(optional = false)
    private Funcion idFuncion;
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento")
    @ManyToOne(optional = false)
    private AsientoSala idAsiento;
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento idDescuento;

    public Boleto() {
    }

    public Boleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Funcion getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Funcion idFuncion) {
        this.idFuncion = idFuncion;
    }

    public AsientoSala getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(AsientoSala idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleto != null ? idBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleto)) {
            return false;
        }
        Boleto other = (Boleto) object;
        if ((this.idBoleto == null && other.idBoleto != null) || (this.idBoleto != null && !this.idBoleto.equals(other.idBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.Boleto[ idBoleto=" + idBoleto + " ]";
    }
    
}
