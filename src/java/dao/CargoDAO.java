package dao;

import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import javax.ejb.Stateful;
import modelo.Cargo;

@Stateful
public class CargoDAO<T> extends GenericDAO<Cargo> implements Serializable {
    public CargoDAO() {
        super();
        super.setPersistentClass(Cargo.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("descricao", "Descrição", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
}
