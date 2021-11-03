package br.edu.unifacear.model.dao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.*;
import br.edu.unifacear.model.util.Connect;

import org.hibernate.Criteria;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class EnderecoDao {
	EntityManager em = Connect.connection();

	public String salvar(Endereco endereco) throws Exception {
		String retorno;
	
		try {			
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();		
			
			retorno = "Endereco Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Endereco\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Endereco endereco) throws Exception {
		String retorno;
		// Gravar o Endereco no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(endereco);
			em.getTransaction().commit();	
			
			retorno = "Endereco Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Endereco\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Endereco endereco) throws Exception {
		String retorno;
		// Gravar o Endereco no BD		
		try {


			Endereco e = em.find(Endereco.class, endereco.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "Endereco Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Endereco\n"+e.getMessage());
		}
		return retorno;		
	} 
	
	public List<Endereco> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Endereco g");
		}
		else {
			q = em.createQuery("select g from Endereco g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Endereco getObjectById(Long id) {

		return em.find(Endereco.class, id);
	}
} // final da classe EnderecoDao
