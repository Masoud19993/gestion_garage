package com.garage.util;

import  jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("garagepu");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}