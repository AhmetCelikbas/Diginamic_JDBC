/**
 * 
 */
package fr.codevallee.formation.tp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author keylan
 *
 */
public class Database {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	
	private static void createEntity(){
		entityManagerFactory = Persistence.createEntityManagerFactory("JSP_TP3");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	private static void destroyEntity(){
		entityManager.close();
		entityManager = null;
	}
	
	public static EntityManager getEntity() {
		if(entityManager == null) {
			createEntity();
		}
		return entityManager;
	}
	
	public static <T> List<T> query(String queryString, Class<T> model) {
		if(entityManager == null) {
			createEntity();
		}
		TypedQuery<T> query = entityManager.createQuery(queryString, model); 
		return query.getResultList();
	}
	
	
	public static <T> T find(Class<T> model, int id) throws IllegalArgumentException {
		if(entityManager == null) {
			createEntity();
		}
		try {
			return entityManager.find(model, id);
		} catch (IllegalArgumentException e) {
			throw e;
		}
		
	}
	
	
	public static void presist(Object obj) {
		if(entityManager == null) {
			createEntity();
		}
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.flush();
		entityManager.getTransaction().commit();
	}
	
	public static void remove(Object obj) {
		if(entityManager == null) {
			createEntity();
		}
		entityManager.getTransaction().begin();
		entityManager.refresh(obj);
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
		destroyEntity();
	}
}
