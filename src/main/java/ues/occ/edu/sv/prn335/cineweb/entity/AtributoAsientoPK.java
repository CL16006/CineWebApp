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
public class AtributoAsientoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caracteristica")
    private int idCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asiento")
    private int idAsiento;

    public AtributoAsientoPK() {
    }

    public AtributoAsientoPK(int idCaracteristica, int idAsiento) {
        this.idCaracteristica = idCaracteristica;
        this.idAsiento = idAsiento;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCaracteristica;
        hash += (int) idAsiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoAsientoPK)) {
            return false;
        }
        AtributoAsientoPK other = (AtributoAsientoPK) object;
        if (this.idCaracteristica != other.idCaracteristica) {
            return false;
        }
        if (this.idAsiento != other.idAsiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.AtributoAsientoPK[ idCaracteristica=" + idCaracteristica + ", idAsiento=" + idAsiento + " ]";
    }
    
}
