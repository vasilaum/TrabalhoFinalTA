package dao;

import controleDAO.ConverterOrder;
import controleDAO.GenericDAO;
import controleDAO.Order;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;
import modelo.Funcionario;

@Stateful
public class FuncionarioDAO<T> extends GenericDAO<Funcionario> implements Serializable {

    public FuncionarioDAO() {
        super();
        super.setPersistentClass(Funcionario.class);
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Funcionario getObjectById(Integer id) throws Exception {
        Funcionario obj = super.getEm().find(Funcionario.class, id);
        return obj;
    }

    public Boolean login(String log, String senha) {
        Query query = super.getEm().createQuery("from Funcionario where upper(login) = :log and upper(senha) = :senha and ativo = true");
        query.setParameter("log", log.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Funcionario localizarFuncionarioPorNome(String log) {
        Funcionario obj = (Funcionario) super.getEm().
                createQuery("from Funcionario where upper(login) = :log").
                setParameter("log", log.toUpperCase()).getSingleResult();
        return obj;
    }
}
