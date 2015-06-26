package dao;
import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import modelo.Filme;

@Stateful
public class FilmeDAO<T> extends GenericDAO<Filme> implements Serializable {
    public FilmeDAO() {
        super();
        super.setPersistentClass(Filme.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
        
    public List<Filme> ListForEnablesMovies(){
        return super.getEm().createQuery("from Filme where disponivel = true").getResultList();
    }
}
