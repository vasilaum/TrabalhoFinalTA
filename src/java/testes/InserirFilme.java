package testes;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Categoria;
import modelo.Filme;

public class InserirFilme {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        EntityManager em = emf.createEntityManager();
        Filme f = new Filme();
        f.setNome("Hu3Hu3 trole seu amiguinho");
        f.setDescricao("Um filme BR nato");
        f.setDataLancamento(Calendar.getInstance());
        f.setClassificacao(18);
        f.setDisponivel(true);
        f.setCategoria(em.find(Categoria.class, 3));
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
