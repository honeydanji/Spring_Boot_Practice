package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		insertData(em);
		updateDate(em);
		deleteDate(em);
		
		em.close();
		emf.close();
	}
	
	
	static void insertData(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			for(int i = 0; i < 10; i++) {
				Board bo = new Board();
				bo.setTitle("하");
				bo.setWriter("성");
				bo.setContent("진");
				bo.setCreateDate(new Date());
				bo.setCnt(0L);
		
				em.persist(bo);
			}			
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	private static void updateDate(EntityManager em) {
		
		Board b = em.find(Board.class, 3L); // find = serch
		
		b.setTitle("새로운 타이틀입니다.");
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.persist(b);
			
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
private static void deleteDate(EntityManager em) {
		
		Board b = em.find(Board.class, 6L); // find = serch
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.remove(b);
			
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	

}
