package br.edu.unifacear.teste;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.unifacear.entity.Contato;
import br.edu.unifacear.entity.Fornecedor;
import br.edu.unifacear.entity.TipoContato;

public class Teste {

	public static void main(String[] args) {
		TipoContato tipo = new TipoContato(0, "Hotmal");
		
		Contato cnt = new Contato(0, "thiago@gmail.com", tipo);
		
		List<Contato> list = new ArrayList<>();
		
		list.add(cnt);
		
		Fornecedor forn = new Fornecedor(0, "Thiago", "Inova", "12.123.123/0001-21", "c@gmail", list, null);
		
		EntityManager em = Connect.connection();
		
		
		
		
		
		em.close();
		
		
		

	}

}
