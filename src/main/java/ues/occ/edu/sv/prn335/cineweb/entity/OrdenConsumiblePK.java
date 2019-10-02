/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fatycalderon
 */
@Embeddable
public class OrdenConsumiblePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden")
    private int idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_consumible")
    private int idConsumible;

    public OrdenConsumiblePK() {
    }

    public OrdenConsumiblePK(int idOrden, int idConsumible) {
        this.idOrden = idOrden;
        this.idConsumible = idConsumible;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdConsumible() {
        return idConsumible;
    }

    public void setIdConsumible(int idConsumible) {
        this.idConsumible = idConsumible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrden;
        hash += (int) idConsumible;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenConsumiblePK)) {
            return false;
        }
        OrdenConsumiblePK other = (OrdenConsumiblePK) object;
        if (this.idOrden != other.idOrden) {
            return false;
        }
        if (this.idConsumible != other.idConsumible) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.OrdenConsumiblePK[ idOrden=" + idOrden + ", idConsumible=" + idConsumible + " ]";
    }
    
}
