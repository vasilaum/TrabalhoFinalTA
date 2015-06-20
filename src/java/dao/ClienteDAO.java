package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Cliente;

@Stateless
public class ClienteDAO implements Serializable{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Cliente> listarTodos;

    public ClienteDAO() {

    }

    public void persistir(Cliente objeto) throws Exception {
        em.persist(objeto);
    }

    public void merger(Cliente objeto) throws Exception {
        em.merge(objeto);
    }

    public void remover(Cliente objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Cliente getObjectById(Integer id) throws Exception {
        return (Cliente) em.find(Cliente.class, id);
    }

    public List<Cliente> getListarTodos() {
        return em.createQuery("from Cliente order by nome").getResultList();
    }

    public void setListarTodos(List<Cliente> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
