package converters;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterBoolean")
public class ConverterBoolean implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return Boolean.parseBoolean(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Boolean b = (Boolean)o;
        if(b){
            return "Sim";
        }
        else{
            return "Não";
        }
    }
}
