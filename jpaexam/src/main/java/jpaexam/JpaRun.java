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
//			Product product = new Product(); 
////			product.setId(2L);
//			product.setName("cup22");
//			product.setPrice(30000);   // 비영속 상태!!   
//			
//			System.out.println("before!!!");
//			em.persist(product);      // 영속상태  --  영속상태라고 해서 DB 에 바로 적용되지는 않는다!!
//			System.out.println("after!!!");
			
			//조회 
			
//			Product findProduct = 	em.find(Product.class, 1L);
//			
//			System.out.println(findProduct);
//			
//			Product findProduct2 = 	em.find(Product.class, 1L);
//			
//			System.out.println(findProduct2);
//			
//			if(findProduct == findProduct2)
//				System.out.println("같아요");
//			else
//				System.out.println("달라요");
//			
//			Product findProduct3 = 	em.find(Product.class, 2L);
//			
//			if(product == findProduct3)
//				System.out.println("같아요");
//			
			
			//수정 
//			Product updateProduct = em.find(Product.class, 1L);
//			updateProduct.setPrice(20000);
//			updateProduct.setName("CUP");
//			
//			
//			System.out.println(updateProduct);
//			
//			updateProduct.setPrice(200);
//			updateProduct.setName("cup");
			
			//삭제
			System.out.println("삭제 전");
			Product delProdcut = em.find(Product.class, 1L);
			em.remove(delProdcut);
			
			System.out.println("삭제 후!!");
			
			
			
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
