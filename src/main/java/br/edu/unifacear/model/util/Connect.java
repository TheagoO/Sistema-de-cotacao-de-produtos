package br.edu.unifacear.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connect {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	
	public static EntityManager connection() {
		return emf.createEntityManager();
	}
	
}
