package dao;
import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import javax.ejb.Stateful;
import modelo.Locacoes;

@Stateful
public class LocacoesDAO<T> extends GenericDAO<Locacoes> implements Serializable {
    public LocacoesDAO() {
        super();
        super.setPersistentClass(Locacoes.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("cliente.nome", "Cliente", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
    
    @Override
     public Locacoes getObjectById(Integer id) throws Exception {
        Locacoes obj = super.getEm().find(Locacoes.class, id);
        obj.getFilmes().size();                
        return obj ;
    }
    
}