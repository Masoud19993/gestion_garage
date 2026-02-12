package com.garage.dao;

import com.garage.model.Voiture;
import com.garage.util.JPAUtil;
import javax.persistence.EntityManager;

import java.util.List;

public class VoitureDAO {
	
	public void ajouter (Voiture v) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public void modifier(Voiture v) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public void supprimer(String immatriculation) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Voiture v = em.find(Voiture.class, immatriculation);
		if (v != null) em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public Voiture findById(String immatriculation) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		Voiture v = em.find(Voiture.class, immatriculation);
		em.close();
		return v;
	}
	
	public List<Voiture> findAll() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Voiture> list = em.createQuery("select v from Voiture v", Voiture.class).getResultList();
		em.close();
		return list;
	}
}