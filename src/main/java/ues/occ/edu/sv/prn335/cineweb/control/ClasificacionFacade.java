/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.prn335.cineweb.entity.Clasificacion;

/**
 *
 * @author fatycalderon
 */
@Stateless
public class ClasificacionFacade extends AbstractFacade<Clasificacion> {

    @PersistenceContext(unitName = "cinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClasificacionFacade() {
        super(Clasificacion.class);
    }
    
     
     /**
      * este metodo busca la entidad por un el nombre de la clasificacion.
      * @param nombre
      * @return 
      */
      public Clasificacion findByNombre(String nombre){
        Clasificacion clasificacion = null;
        if(em!=null && nombre!=null && !nombre.isEmpty()){
            clasificacion=(Clasificacion)em.createQuery("select c from Clasificacion c where c.clasificacion=:nombre")
                    .setParameter("nombre", nombre).getSingleResult();
        }
        return clasificacion;
    }
}
