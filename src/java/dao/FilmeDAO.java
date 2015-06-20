package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Filme;

@Stateless
public class FilmeDAO implements Serializable{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Filme> listarTodos;

    public FilmeDAO() {

    }

    public void persistir(Filme objeto) throws Exception {
        em.persist(objeto);
    }

    public void merger(Filme objeto) throws Exception {
        em.merge(objeto);
    }

    public void remover(Filme objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Filme getObjectById(Integer id) throws Exception {
        return (Filme) em.find(Filme.class, id);
    }

    public List<Filme> getListarTodos() {
        return em.createQuery("from Filme order by nome").getResultList();
    }

    public void setListarTodos(List<Filme> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
