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
@Table(name = "tipo_descuento")
@NamedQueries({
    @NamedQuery(name = "TipoDescuento.findAll", query = "SELECT t FROM TipoDescuento t"),
    @NamedQuery(name = "TipoDescuento.findByIdTipoDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.idTipoDescuento = :idTipoDescuento"),
    @NamedQuery(name = "TipoDescuento.findByTipo", query = "SELECT t FROM TipoDescuento t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoDescuento.findByDescripcion", query = "SELECT t FROM TipoDescuento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoDescuento.findByAplicableBoleto", query = "SELECT t FROM TipoDescuento t WHERE t.aplicableBoleto = :aplicableBoleto"),
    @NamedQuery(name = "TipoDescuento.findByAplicableConsumible", query = "SELECT t FROM TipoDescuento t WHERE t.aplicableConsumible = :aplicableConsumible"),
    @NamedQuery(name = "TipoDescuento.findByPorcentajeSugerido", query = "SELECT t FROM TipoDescuento t WHERE t.porcentajeSugerido = :porcentajeSugerido"),
    @NamedQuery(name = "TipoDescuento.findByActivo", query = "SELECT t FROM TipoDescuento t WHERE t.activo = :activo")})
public class TipoDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_descuento")
    private Integer idTipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aplicable_boleto")
    private boolean aplicableBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aplicable_consumible")
    private boolean aplicableConsumible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_sugerido")
    private double porcentajeSugerido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDescuento")
    private Collection<Descuento> descuentoCollection;

    public TipoDescuento() {
    }

    public TipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public TipoDescuento(Integer idTipoDescuento, String tipo, String descripcion, boolean aplicableBoleto, boolean aplicableConsumible, double porcentajeSugerido, boolean activo) {
        this.idTipoDescuento = idTipoDescuento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.aplicableBoleto = aplicableBoleto;
        this.aplicableConsumible = aplicableConsumible;
        this.porcentajeSugerido = porcentajeSugerido;
        this.activo = activo;
    }

    public Integer getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getAplicableBoleto() {
        return aplicableBoleto;
    }

    public void setAplicableBoleto(boolean aplicableBoleto) {
        this.aplicableBoleto = aplicableBoleto;
    }

    public boolean getAplicableConsumible() {
        return aplicableConsumible;
    }

    public void setAplicableConsumible(boolean aplicableConsumible) {
        this.aplicableConsumible = aplicableConsumible;
    }

    public double getPorcentajeSugerido() {
        return porcentajeSugerido;
    }

    public void setPorcentajeSugerido(double porcentajeSugerido) {
        this.porcentajeSugerido = porcentajeSugerido;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Collection<Descuento> getDescuentoCollection() {
        return descuentoCollection;
    }

    public void setDescuentoCollection(Collection<Descuento> descuentoCollection) {
        this.descuentoCollection = descuentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDescuento != null ? idTipoDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDescuento)) {
            return false;
        }
        TipoDescuento other = (TipoDescuento) object;
        if ((this.idTipoDescuento == null && other.idTipoDescuento != null) || (this.idTipoDescuento != null && !this.idTipoDescuento.equals(other.idTipoDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.TipoDescuento[ idTipoDescuento=" + idTipoDescuento + " ]";
    }
    
}
