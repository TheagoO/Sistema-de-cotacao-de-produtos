package br.edu.unifacear.teste;

import javax.persistence.EntityManager;

public class Teste {

	public static void main(String[] args) {
	
		EntityManager em = Connect.connection();		
		em.close();
		
	}

}
