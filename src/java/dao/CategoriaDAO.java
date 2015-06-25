package dao;
import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import javax.ejb.Stateful;
import modelo.Categoria;

@Stateful
public class CategoriaDAO<T> extends GenericDAO<Categoria> implements Serializable {
    public CategoriaDAO(){
        super();
        super.setPersistentClass(Categoria.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("descricao", "Descrição", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));                
    }
}