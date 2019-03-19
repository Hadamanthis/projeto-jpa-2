package br.com.caelum.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TesteLockPessimista {
	
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context=  new AnnotationConfigApplicationContext(JpaConfigurator.class);
		EntityManagerFactory fmt = context.getBean(EntityManagerFactory.class);
		
		EntityManager em1 = fmt.createEntityManager();
		EntityManager em2 = fmt.createEntityManager();
			
		em1.getTransaction().begin();
		em2.getTransaction().begin();
		
		Produto produtoDoEm1 = em1.find(Produto.class, 1, LockModeType.PESSIMISTIC_WRITE);
		
		System.out.println("Trocando o nome do livro");
		produtoDoEm1.setNome("Livro");
		
		Produto produtoDoEm2 = em2.find(Produto.class, 1, LockModeType.PESSIMISTIC_WRITE); // Aqui da lock
		
	}
	
}
