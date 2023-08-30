package com.videodb.DAO;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class jpaDAO <E> {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("VideoProject");
	}
	
	public jpaDAO() {
	}
	
	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		
		if (entity != null) {
			entityManager.refresh(entity);
		}
		entityManager.close();
		
		return entity;
	}
	
	public void delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<E> findWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}

	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	


	public List<Object[]> findWithNamedQueryObjects(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		
		List<Object[]> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public List<Object[]> findWithNamedQueryMax(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		
		List<Object[]> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	
	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		
		query.setParameter(paramName, paramValue);
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}

	public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		
		for (Entry<String, Object> entry : setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public List<E> findWithNativedQuery(String queryName, Map<String, Object> parameters) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNativeQuery(queryName);
		
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		
		for (Entry<String, Object> entry : setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public List<E> findWithNativedQuery(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNativeQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	

	
	public List<E> findWithNativedQuery(String queryName, String paramName, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNativeQuery(queryName);
		
		query.setParameter(paramName, paramValue);
		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	
	
	public List<E> findWithNativedQuery(String queryName, String paramName1, String paramName2, 
			int paramValue1, int paramValue2) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNativeQuery(queryName);
		
		query.setParameter(paramName1, paramValue1);
		query.setParameter(paramName2, paramValue2);
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public List<E> findWithNativedQuery2(String queryName, int paramValue1, int paramValue2) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		
		query.setParameter(1, paramValue1);
		query.setParameter(2, paramValue2);
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	
	public List<E> findWithNativedQuery(String queryName, int paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		
		query.setParameter(1, paramValue);
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public List<E> findWithNativedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		List<E> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}
	
	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		
		long result = (long) query.getSingleResult();
		entityManager.close();
		
		return result;
	}

	public long countWithNamedQuery(String queryName, String paramName, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		
		long result = (long) query.getSingleResult();
		entityManager.close();
		
		return result;
	}	
	public void close() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}