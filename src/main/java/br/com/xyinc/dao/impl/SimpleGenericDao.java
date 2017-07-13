package br.com.xyinc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleGenericDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Getter de session a partir do entityManager
	 * 
	 * @return session
	 */
	protected Session getSession() {
		Session session = (Session) this.entityManager.getDelegate();
		return session;
	}

	/**
	 * Metodo para persistir uma entidade
	 * 
	 * @param entity
	 */
	protected <A> void persist(A entity) {
		this.getSession().persist(entity);
	}

	/**
	 * Metodo para realizar o update de uma entidade
	 * 
	 * @param entity
	 */
	protected <A> void merge(A entity) {
		this.getSession().merge(entity);
	}

	/**
	 * Metodo para relizar o delete de uma entidade
	 * 
	 * @param entity
	 */
	protected <A> void remove(A entity) {
		this.getSession().delete(entity);
	}

}
