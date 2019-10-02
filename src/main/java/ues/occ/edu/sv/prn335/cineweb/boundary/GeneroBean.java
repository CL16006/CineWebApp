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
import ues.occ.edu.sv.prn335.cineweb.control.GeneroFacade;
import ues.occ.edu.sv.prn335.cineweb.entity.Genero;
import ues.occ.edu.sv.prn335.cineweb.entity.Pelicula;


/**
 *
 * @author fatycalderon
 */

@Named(value="generoBean")
@ViewScoped
public class GeneroBean implements Serializable {
    @EJB
private GeneroFacade generoFacade;
    
    private Genero genero;
    private Genero generoSelected;
    protected LazyDataModel<Genero> generoLDM;
    private List<Pelicula> peliculaList;
    
    @PostConstruct
    public void iniciar(){
        genero=new Genero();
        genero.setIdGenero(null);
        genero.setNombre("");
        genero.setDescripcion("");
        genero.setActivo(false);
        
        obtenerLDM();
    
    }

    
    public LazyDataModel<Genero> obtenerLDM(){
        try{
        this.generoLDM=new LazyDataModel<Genero>(){
            @Override
            public Object getRowKey(Genero object) {               
                 if(object!=null){
                     return object.getIdGenero();
                 }
                 return null;
            }

            @Override
            public Genero getRowData(String rowKey) {
                if(rowKey!=null && !rowKey.isEmpty() && this.getWrappedData()!=null){
                    try{
                        Integer search=new Integer(rowKey);
                        for (Genero g :(List<Genero>) getWrappedData()) {
                            if(g.getIdGenero().compareTo(search)==0){
                                return g;
                            }
                        }
                        
                    }catch(NumberFormatException e){
                       Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(), e);
                    }
                }
                return null;
            }
            
            @Override
            public List<Genero> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            List<Genero> lista=new ArrayList<>();
            try{
                if(generoFacade!=null){
                    this.setRowCount(generoFacade.count());
                    lista=generoFacade.findRange(first, pageSize);
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
        return this.generoLDM;
    }

    public GeneroFacade getGeneroFacade() {
        return generoFacade;
    }

    public void setGeneroFacade(GeneroFacade generoFacade) {
        this.generoFacade = generoFacade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LazyDataModel<Genero> getGeneroLDM() {
        return generoLDM;
    }

    public void setGeneroLDM(LazyDataModel<Genero> generoLDM) {
        this.generoLDM = generoLDM;
    }

    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }
    
  
}
