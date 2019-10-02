/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.boundary;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import ues.occ.edu.sv.prn335.cineweb.control.ClasificacionFacade;
import ues.occ.edu.sv.prn335.cineweb.entity.Clasificacion;




/**
 *
 * @author fatycalderon
 */
@FacesConverter(forClass =Clasificacion.class ,value="clasificacionConverter")
public class ClasificacionConverter implements Converter{

   @Inject
   ClasificacionFacade facade;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
                 if(fc==null){
            throw new NullPointerException("facesContext es nulo");
        }
        if(ui==null){
            throw new NullPointerException("UIComponent es nulo");
        }      
        Clasificacion clasificacion;
        try{
        clasificacion=facade.findByNombre(value);
        }catch(NumberFormatException e){
           throw new ConverterException();
        }
        if(clasificacion==null){
            throw new ConverterException();
        }
        
        return clasificacion;
       }

    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object object) {
        if(fc==null){
            throw new NullPointerException("facesContext es null");
        }
        if(ui==null){
            throw new NullPointerException("UIComponet es null");
        }
        return String.valueOf(((Clasificacion)object).getIdClasificacion());
         }
    
    
}
