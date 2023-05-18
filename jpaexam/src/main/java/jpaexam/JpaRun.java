package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRun {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");
		EntityManager em =	emf.createEntityManager();  //인테티 메지저가 생성될 때 영속성 컨텍스트가 생성됨!!
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			
		try {
			//등록 
			Product product = new Product(); 
			product.setId(2L);
			product.setName("notebook");
			product.setPrice(5000000);   // 비영속 상태!!   
			
			System.out.println("before!!!");
			em.persist(product);      // 영속상태  --  영속상태라고 해서 DB 에 바로 적용되지는 않는다!!
			System.out.println("after!!!");
			
			
			
			System.out.println("tx before!!");
			tx.commit();
			System.out.println("tx after!!");
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}

}
