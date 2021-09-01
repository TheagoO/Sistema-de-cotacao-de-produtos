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

public class EstadoDao {
	EntityManager em = Connect.connection();

	public String salvar(Estado estado) throws Exception {
		String retorno;
		// Gravar o Estado no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(estado);
			em.getTransaction().commit();		
			
			retorno = "Estado Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Estado\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Estado estado) throws Exception {
		String retorno;
		// Gravar o Estado no BD		
		try {
			
			em.getTransaction().begin();
			em.merge(estado);
			em.getTransaction().commit();	
			
			retorno = "Estado Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Estado\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Estado estado) throws Exception {
		String retorno;
		// Gravar o Estado no BD		
		try {


			Estado e = em.find(Estado.class, estado.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Estado Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Estado\n"+e.getMessage());
		}
		return retorno;		
	} // deletar


	public List<Estado> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Estado g");
		}
		else {
			q = em.createQuery("select g from Estado g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	
	public Estado getObjectById(Long id) {
	
		return em.find(Estado.class, id);
	}
} // final da classe EstadoDao
