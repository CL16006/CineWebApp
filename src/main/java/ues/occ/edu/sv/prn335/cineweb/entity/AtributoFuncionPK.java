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
public class AtributoFuncionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caracteristica")
    private int idCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_funcion")
    private int idFuncion;

    public AtributoFuncionPK() {
    }

    public AtributoFuncionPK(int idCaracteristica, int idFuncion) {
        this.idCaracteristica = idCaracteristica;
        this.idFuncion = idFuncion;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCaracteristica;
        hash += (int) idFuncion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoFuncionPK)) {
            return false;
        }
        AtributoFuncionPK other = (AtributoFuncionPK) object;
        if (this.idCaracteristica != other.idCaracteristica) {
            return false;
        }
        if (this.idFuncion != other.idFuncion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.prn335.cineweb.entity.AtributoFuncionPK[ idCaracteristica=" + idCaracteristica + ", idFuncion=" + idFuncion + " ]";
    }
    
}
