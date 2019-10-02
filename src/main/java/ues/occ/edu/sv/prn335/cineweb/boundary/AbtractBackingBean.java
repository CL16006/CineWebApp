/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.prn335.cineweb.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author fatycalderon
 * @param <T>
 */
public abstract class AbtractBackingBean<T> {
    protected T t;
    protected LazyDataModel<T> tLDM;
     private Class<T> facade;

    
    public AbtractBackingBean(Class<T> facade) {
        this.facade = facade;
    }
    
    @PostConstruct
      public void inicializar(){
          
          this.obtenerLDM();
      }
    
     public LazyDataModel<T> obtenerLDM(){
        try{
        this.tLDM=new LazyDataModel<T>(){
            @Override
            public Object getRowKey(T object) {               
                 if(object!=null){
                     return object;
                 }
                 return null;
            }

            @Override
            public T getRowData(String rowKey) {
                if(rowKey!=null && !rowKey.isEmpty() && this.getWrappedData()!=null){
                    try{
                        Integer search=new Integer(rowKey);
                        for (T t :(List<T>) getWrappedData()) {
//                            if(t.compareTo(search)==0){
                                return t;
//                            }
                        }
                        
                    }catch(NumberFormatException e){
                       Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(), e);
                    }
                }
                return null;
            }
            
            @Override
            public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            List<T> lista=new ArrayList<>();
            try{
//                if(facade!=null){
//                    this.setRowCount(facade.count());
//                    lista=facade.findRange(first, pageSize);
//                }
                
            }catch(Exception e){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return lista;
            }
            
        };
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return this.tLDM;
    }
}
