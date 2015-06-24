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
        // definindo a classe persistence
        super.setPersistentClass(Cliente.class);
        // definindo as ordenaçõe possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

}
