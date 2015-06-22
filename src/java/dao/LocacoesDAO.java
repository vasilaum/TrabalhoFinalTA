package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Locacoes;

@Stateless
public class LocacoesDAO implements Serializable {

    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Locacoes> listarTodos;
    
    public LocacoesDAO() {
        
    }
    
    public void persistir(Locacoes objeto) throws Exception {
        em.persist(objeto);
    }
    
    public void merge(Locacoes objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remover(Locacoes objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Locacoes getObjectById(Integer id) throws Exception {
        Locacoes obj = em.find(Locacoes.class, id);
        obj.getFilmes().size();                
        return obj ;
    }
    
    public List<Locacoes> getListarTodos() {
        return em.createQuery("from Locacoes").getResultList();
    }
    
    public void setListarTodos(List<Locacoes> listarTodos) {
        this.listarTodos = listarTodos;
    }    
    
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}