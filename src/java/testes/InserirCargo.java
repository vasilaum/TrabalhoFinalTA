package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cargo;

public class InserirCargo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        EntityManager em = emf.createEntityManager();
        Cargo c = new Cargo();
        c.setDescricao("Gerente");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
