/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.prn335.cineweb.entity.AsientoSala;

/**
 *
 * @author fatycalderon
 */
@Stateless
public class AsientoSalaFacade extends AbstractFacade<AsientoSala> {

    @PersistenceContext(unitName = "cinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsientoSalaFacade() {
        super(AsientoSala.class);
    }
    
}
