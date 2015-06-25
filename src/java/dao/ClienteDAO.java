package dao;
import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import javax.ejb.Stateful;
import modelo.Cliente;

@Stateful
public class ClienteDAO<T> extends GenericDAO<Cliente> implements Serializable {
    public ClienteDAO() {
        super();
        super.setPersistentClass(Cliente.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

}
