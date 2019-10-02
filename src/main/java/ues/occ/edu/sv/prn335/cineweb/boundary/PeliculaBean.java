/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ues.occ.edu.sv.prn335.cineweb.control.ClasificacionFacade;
import ues.occ.edu.sv.prn335.cineweb.control.DirectorFacade;
import ues.occ.edu.sv.prn335.cineweb.control.PeliculaFacade;
import ues.occ.edu.sv.prn335.cineweb.entity.Clasificacion;
import ues.occ.edu.sv.prn335.cineweb.entity.Director;
import ues.occ.edu.sv.prn335.cineweb.entity.Genero;
import ues.occ.edu.sv.prn335.cineweb.entity.Pelicula;

/**
 *
 * @author fatycalderon
 */
@Named
@ViewScoped
public class PeliculaBean implements Serializable {
    @EJB
    PeliculaFacade peliculaFacade;
    
    @EJB
    ClasificacionFacade clasificacionFacade;
    
    @EJB
    DirectorFacade directorFacade;
    
    private Pelicula pelicula;
    private Genero generoSelected;
    private LazyDataModel<Pelicula> peliculaLDM;
    private List<Clasificacion> listaClasificacion;
    private List<Director> listaDirector;
    private Clasificacion clSelected;
   
    
    @PostConstruct
    public void iniciar(){
        pelicula=new Pelicula();
        
        pelicula.setIdClasificacion(null);
        pelicula.setIdDirector(null);
        pelicula.setDuracion("");
        pelicula.setTitulo("");
        pelicula.setFechaEstreno(new Date());
        pelicula.setSinopsis("");
        obtenerLDM();
        try{
            this.listaClasificacion=clasificacionFacade.findAll();
            
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(), e);
        }
        try{
            this.listaDirector=directorFacade.findAll();
            
        }catch(Exception e){
             Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(), e);
        }
    }
    
    
    public LazyDataModel<Pelicula> obtenerLDM(){
        try{
        this.peliculaLDM=new LazyDataModel<Pelicula>(){
            @Override
            public Object getRowKey(Pelicula object) {               
                 if(object!=null){
                     return object.getIdPelicula();
                 }
                 return null;
            }

            @Override
            public Pelicula getRowData(String rowKey) {
                if(rowKey!=null && !rowKey.isEmpty() && this.getWrappedData()!=null){
                    try{
                        Integer search=new Integer(rowKey);
                        for (Pelicula p :(List<Pelicula>) getWrappedData()) {
                            if(p.getIdPelicula().compareTo(search)==0){
                                return p;
                            }
                        }
                        
                    }catch(NumberFormatException e){
                       Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(), e);
                    }
                }
                return null;
            }
            
            @Override
            public List<Pelicula> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            List<Pelicula> lista=new ArrayList<>();
            try{
                if(peliculaFacade!=null){
                    this.setRowCount(peliculaFacade.count());
                    lista=peliculaFacade.findRange(first, pageSize);
                }
                
            }catch(Exception e){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return lista;
            }
            
        };
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return this.peliculaLDM;
    }
    
        
    public void onItemSelected(SelectEvent event){
    
        clSelected = (Clasificacion) event.getObject();
        System.out.println("GENERO "+ clSelected.getClasificacion());
}
     
    public void addMessage(String summary, String detail){
        FacesMessage fm=new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void crear(SelectEvent ae){
        pelicula.setIdClasificacion(clSelected);
        try{
        if(peliculaFacade!=null && this.pelicula!=null){
            this.peliculaFacade.create(pelicula);
            iniciar();
            addMessage("EXITO!", "El registro se creo con exito");
        }
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
    }
    
     public void eliminar(SelectEvent ae){
        pelicula.setIdClasificacion(clSelected);
        try{
        if(peliculaFacade!=null && this.pelicula!=null){
            this.peliculaFacade.remove(pelicula);
            iniciar();
            addMessage("EXITO!", "El registro ha sido eliminado");
        }
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
    }
    
    public void modificar(SelectEvent ae){
        pelicula.setIdClasificacion(clSelected);
        try{
        if(peliculaFacade!=null && this.pelicula!=null){
            this.peliculaFacade.edit(pelicula);
            iniciar();
            addMessage("EXITO!", "El se modifico con exito");
        }
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
    }
    
    public void onRowSelect(SelectEvent event) {
        this.pelicula= (Pelicula) event.getObject();    
    }
    
     public void onRowDeselect(UnselectEvent event) {
      
        this.pelicula= new Pelicula();
        this.peliculaLDM.setRowIndex(-1);

    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public PeliculaFacade getPeliculaFacade() {
        return peliculaFacade;
    }

    public void setPeliculaFacade(PeliculaFacade peliculaFacade) {
        this.peliculaFacade = peliculaFacade;
    }

    public LazyDataModel<Pelicula> getPeliculaLDM() {
        return peliculaLDM;
    }

    public void setPeliculaLDM(LazyDataModel<Pelicula> peliculaLDM) {
        this.peliculaLDM = peliculaLDM;
    }

    public List<Clasificacion> getListaClasificacion() {
        return listaClasificacion;
    }

    public void setListaClasificacion(List<Clasificacion> listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
    }

    public List<Director> getListaDirector() {
        return listaDirector;
    }

    public void setListaDirector(List<Director> listaDirector) {
        this.listaDirector = listaDirector;
    }

    public Clasificacion getClSelected() {
        return clSelected;
    }

    public void setClSelected(Clasificacion clSelected) {
        this.clSelected = clSelected;
    }
    
 
}
