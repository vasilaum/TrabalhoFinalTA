package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Categoria;

@Stateless
public class CategoriaDAO implements Serializable{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Categoria> listarTodos;

    public CategoriaDAO() {

    }

    public void persistir(Categoria objeto) throws Exception {
        em.persist(objeto);
    }

    public void merger(Categoria objeto) throws Exception {
        em.merge(objeto);
    }

    public void remover(Categoria objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Categoria getObjectById(Integer id) throws Exception {
        return (Categoria) em.find(Categoria.class, id);
    }

    public List<Categoria> getListarTodos() {
        return em.createQuery("from Categoria order by descricao").getResultList();
    }

    public void setListarTodos(List<Categoria> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
