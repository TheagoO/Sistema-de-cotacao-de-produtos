package br.edu.unifacear.teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.unifacear.dao.Connect;
import br.edu.unifacear.entity.Cidade;
import br.edu.unifacear.entity.Contato;
import br.edu.unifacear.entity.Endereco;
import br.edu.unifacear.entity.Estado;
import br.edu.unifacear.entity.Fornecedor;
import br.edu.unifacear.entity.TipoContato;

public class Teste {

	public static void main(String[] args) {
	
		EntityManager em = Connect.connection();		
		
		EntityTransaction et = em.getTransaction();
		
		Estado e = new Estado(1, "PR", 41);
		
		
		
		Cidade c = new Cidade(2, "Curitiba", 41, e);
		
		
		
		TipoContato tc = new TipoContato(1, "Celular");
		
		Contato cnt = new Contato(1, "(41)99848-3945", tc);
		
		
		
		Fornecedor f = new Fornecedor(0, "Jose", "Inovatech", "12.123.123/0001-92", "t@gmail.com", new ArrayList<>(), new ArrayList<>());
		f.setContato(cnt);
		
		Endereco end = new Endereco(1, "Rua J. T. I", 752, "Casa", "83-707.758", c);
				
		f.setEndereco(end);
		
		et.begin();
		em.persist(f);
		et.commit();
		
		
		em.close();
		
	}

}
