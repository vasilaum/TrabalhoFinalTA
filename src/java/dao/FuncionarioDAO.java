package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Funcionario;

@Stateless
public class FuncionarioDAO implements Serializable{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Funcionario> listarTodos;

    public FuncionarioDAO() {

    }

    public void persistir(Funcionario objeto) throws Exception {
        em.persist(objeto);
    }

    public void merger(Funcionario objeto) throws Exception {
        em.merge(objeto);
    }

    public void remover(Funcionario objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Funcionario getObjectById(Integer id) throws Exception {
        return (Funcionario) em.find(Funcionario.class, id);
    }

    public List<Funcionario> getListarTodos() {
        return em.createQuery("from Funcionario order by nome").getResultList();
    }

    public void setListarTodos(List<Funcionario> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
