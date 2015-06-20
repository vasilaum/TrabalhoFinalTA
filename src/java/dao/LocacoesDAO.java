package dao;
import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import modelo.Locacoes;

public class LocacoesDAO<T> extends GenericDAO<Locacoes> implements Serializable{
    public LocacoesDAO(){
        super(); // definindo a classe persistence
        super.setPersistentClass(Locacoes.class); // definindo as ordenaçõe possiveis
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("cliente", "Cliente", "like")); // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));                
    }
    
      public Locacoes debugList(Integer id) throws Exception {
        Locacoes obj = (Locacoes)getObjectById(id);
        obj.getFilmes().size();                
        return obj ;
    }
}

