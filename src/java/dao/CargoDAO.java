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
        // definindo a classe persistence
        super.setPersistentClass(Cargo.class);
        // definindo as ordenaçõe possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("descricao", "Descrição", "like"));
        // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

}
