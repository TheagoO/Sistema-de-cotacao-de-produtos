package br.edu.unifacear.dao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.entity.*;



import org.hibernate.Criteria;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class ContatoDao {
	EntityManager em = Connect.connection();

	public String salvar(Contato contato) throws Exception {
		String retorno;
		// Gravar o Contato no BD
		
		try {			
			em.getTransaction().begin();
			em.persist(contato);
			em.getTransaction().commit();		
			
			retorno = "Contato Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Contato\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Contato contato) throws Exception {
		String retorno;
		// Gravar o Contato no BD		
		try {
	
			em.getTransaction().begin();
			em.merge(contato);
			em.getTransaction().commit();	
			
			retorno = "Contato Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Contato\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Contato contato) throws Exception {
		String retorno;
		// Gravar o Contato no BD		
		try {


			Contato e = em.find(Contato.class, contato.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Contato Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Contato\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<Contato> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Contato g");
		}
		else {
			q = em.createQuery("select g from Contato g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Contato getObjectById(Long id) {
		
		return em.find(Contato.class, id);
	}
} // final da classe ContatoDao
