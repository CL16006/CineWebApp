/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ues.occ.edu.sv.prn335.cineweb.control.ClasificacionFacade;
import ues.occ.edu.sv.prn335.cineweb.entity.Clasificacion;


/**
 *
 * @author fatycalderon
 */
@Named
@ViewScoped
public class ClasificacionBean implements Serializable{
    @EJB
   private ClasificacionFacade clasificacionFacade;
    
    private Clasificacion clasificacion;
    
   private LazyDataModel<Clasificacion> clasificacionLDM;
    
    @PostConstruct
    public void iniciar(){
     clasificacion=new Clasificacion();
     clasificacion.setIdClasificacion(null);
     clasificacion.setClasificacion("");
     clasificacion.setDescripcion("");
     LDM();
    }
    
    public LazyDataModel<Clasificacion> LDM(){
        try{
        this.clasificacionLDM=new LazyDataModel<Clasificacion>(){
            @Override
            public Object getRowKey(Clasificacion object) {
                if(object!=null){
                return object.getIdClasificacion();
                        }
                return null;
            }

            @Override
            public List<Clasificacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
               List<Clasificacion> lista=new ArrayList<Clasificacion>(); 
               try{
                   if(clasificacionFacade!=null){
                       this.setRowCount(clasificacionFacade.count());
                       lista=clasificacionFacade.findRange(first, pageSize);
                   }
               }catch(Exception e){
                   Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(),e);
               }
               return lista;
            }

            @Override
            public Clasificacion getRowData(String rowKey) {
            try{
                Integer search=new Integer(rowKey);
                for(Clasificacion c:(List<Clasificacion>)getWrappedData()){
                    if(c.getIdClasificacion().compareTo(search)==0){
                        return c;
                    }
                }
                
            }catch(Exception e){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }   
            return null;
            }
            
             };
        }catch(Exception e){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }   
        return this.clasificacionLDM;
    }

    public ClasificacionFacade getClasificacionFacade() {
        return clasificacionFacade;
    }

    public void setClasificacionFacade(ClasificacionFacade clasificacionFacade) {
        this.clasificacionFacade = clasificacionFacade;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LazyDataModel<Clasificacion> getClasificacionLDM() {
        return clasificacionLDM;
    }

    public void setClasificacionLDM(LazyDataModel<Clasificacion> clasificacionLDM) {
        this.clasificacionLDM = clasificacionLDM;
    }
    
    
    
}
