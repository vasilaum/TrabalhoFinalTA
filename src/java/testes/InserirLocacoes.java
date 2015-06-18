package testes;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;
import modelo.Filme;
import modelo.Locacoes;

public class InserirLocacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        EntityManager em = emf.createEntityManager();
        Locacoes l = new Locacoes();
        l.setDataLocacao(Calendar.getInstance());
        l.setDataEntrega(Calendar.getInstance());
        l.setValorLocacao(120.00);
        l.setEntregue(true);
        l.setCliente(em.find(Cliente.class, 2));
        l.adicionarFilmes(em.find(Filme.class, 1));
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
