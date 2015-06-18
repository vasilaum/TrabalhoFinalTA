/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cargo;
import modelo.Funcionario;

/**
 *
 * @author Huanter
 */
public class InserirFuncionario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalTAPULocal");
        EntityManager em = emf.createEntityManager();
        Funcionario fun = new Funcionario();
        fun.setNome("Paulo");
        fun.setDataNascimento(Calendar.getInstance());
        fun.setCpf("029.201.100-80");
        fun.setRg("1234567891");
        fun.setEmail("paulo@hotmail.com");
        fun.setNumeroCarteiraTrab("123.123.123-90");
        fun.setSalario(700.00);
        fun.setDataContratacao(Calendar.getInstance());
        fun.setCargo(em.find(Cargo.class, 1));
        fun.setAtivo(true);
        em.getTransaction().begin();
        em.persist(fun);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
