package testes;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;

public class InserirCliente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        EntityManager em = emf.createEntityManager();
        Cliente c = new Cliente();
        c.setNome("Huanter");
        c.setDataNascimento(Calendar.getInstance());
        c.setCpf("029.201.100-80");
        c.setEmail("huanter@hotmail.com");
        c.setEndereco("Rua São Borja");
        c.setBairro("Vera Cruz");
        c.setDataCadastro(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
