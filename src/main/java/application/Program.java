package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "pessoa1", "pessoa1@gmail.com");
		Pessoa p2 = new Pessoa(null, "pessoa2", "pessoa2@gmail.com");
		
		//INSTANCE EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		//INSTANCE EntityManeger
		EntityManager em = emf.createEntityManager();
		
		//SEMPRE QUE REALIZAR UMA OPERA��O QUE N�O SEJA UMA SIMPLES LEITURA NO BD � NECESSARIO UMA TRANSA��O
		//INICIA UMA TRASA��O COM em.getTransaction().begin();
		//em.getTransaction().begin();
		//OPERA��O .persist insere dados no BD
		//em.persist(p1);
		//em.persist(p2);
		//APOS REALIZAR A OPERA��O, CONFIRMAR COM em.getTransaction().commit();
		//em.getTransaction().commit();
		
		
		//REALIZA UM SELECT
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p.getId());
		
		emf.close();
		em.close();
	}

}
