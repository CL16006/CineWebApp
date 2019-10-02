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
@Table(name = "orden_consumible")
@NamedQueries({
    @NamedQuery(name = "OrdenConsumible.findAll", query = "SELECT o FROM OrdenConsumible o"),
    @NamedQuery(name = "OrdenConsumible.findByIdOrden", query = "SELECT o FROM OrdenConsumible o WHERE o.ordenConsumiblePK.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenConsumible.findByIdConsumible", query = "SELECT o FROM OrdenConsumible o WHERE o.ordenConsumiblePK.idConsumible = :idConsumible"),
    @NamedQuery(name = "OrdenConsumible.findByCantidad", query = "SELECT o FROM OrdenConsumible o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenConsumible.findByMontoTotal", query = "SELECT o FROM OrdenConsumible o WHERE o.montoTotal = :montoTotal")})
public class OrdenConsumible implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenConsumiblePK ordenConsumiblePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total")
    private double montoTotal;
    @JoinColumn(name = "id_consumible", referencedColumnName = "id_consumible", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MenuConsumible menuConsumible;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orden orden;

    public OrdenConsumible() {
    }

    public OrdenConsumible(OrdenConsumiblePK ordenConsumiblePK) {
        this.ordenConsumiblePK = ordenConsumiblePK;
    }

    public OrdenConsumible(OrdenConsumiblePK ordenConsumiblePK, int cantidad, double montoTotal) {
        this.ordenConsumiblePK = ordenConsumiblePK;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }

    public OrdenConsumible(int idOrden, int idConsumible) {
        this.ordenConsumiblePK = new OrdenConsumiblePK(idOrden, idConsumible);
    }

    public OrdenConsumiblePK getOrdenConsumiblePK() {
        return ordenConsumiblePK;
    }

    public void setOrdenConsumiblePK(OrdenConsumiblePK ordenConsumiblePK) {
        this.ordenConsumiblePK = ordenConsumiblePK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public MenuConsumible getMenuConsumible() {
        return menuConsumible;
    }

    public void setMenuConsumible(MenuConsumible menuConsumible) {
        this.menuConsumible = menuConsumible;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenConsumiblePK != null ? ordenConsumiblePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenConsumible)) {
            return false;
        }
        OrdenConsumible other = (OrdenConsumible) object;
        if ((this.ordenConsumiblePK == null && other.ordenConsumiblePK != null) || (this.ordenConsumiblePK != null && !this.ordenConsumiblePK.equals(other.ordenConsumiblePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.OrdenConsumible[ ordenConsumiblePK=" + ordenConsumiblePK + " ]";
    }
    
}
