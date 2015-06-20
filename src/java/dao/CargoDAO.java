package dao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Cargo;

@Stateless
public class CargoDAO implements Serializable{
    
    @PersistenceContext(unitName = "TrabalhoFinalTAPU")
    private EntityManager em;
    private List<Cargo> listarTodos;

    public CargoDAO() {

    }

    public void persistir(Cargo objeto) throws Exception {
        em.persist(objeto);
    }

    public void merger(Cargo objeto) throws Exception {
        em.merge(objeto);
    }

    public void remover(Cargo objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Cargo getObjectById(Integer id) throws Exception {
        return (Cargo) em.find(Cargo.class, id);
    }

    public List<Cargo> getListarTodos() {
        return em.createQuery("from Cargo order by descricao").getResultList();
    }

    public void setListarTodos(List<Cargo> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
