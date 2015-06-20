package converters;

import modelo.Categoria;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@FacesConverter(value = "converterCategoria")
public class ConverterCategoria implements Serializable, Converter {
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Categoria.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Categoria obj = (Categoria) o;
        return obj.getId().toString();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    

}
