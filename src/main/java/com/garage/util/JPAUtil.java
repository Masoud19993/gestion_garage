package com.garage.util;

import  javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("garagePU");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}