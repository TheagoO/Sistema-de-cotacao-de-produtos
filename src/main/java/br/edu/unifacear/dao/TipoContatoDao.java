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

public class TipoContatoDao {
	EntityManager em = Connect.connection();
	public String salvar(TipoContato tipocontato) throws Exception {
		String retorno;
		// Gravar o TipoContato no BD

		try {			
			em.getTransaction().begin();
			em.persist(tipocontato);
			em.getTransaction().commit();		
			
			retorno = "TipoContato Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando TipoContato\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(TipoContato tipocontato) throws Exception {
		String retorno;
		// Gravar o TipoContato no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(tipocontato);
			em.getTransaction().commit();	
			
			retorno = "TipoContato Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando TipoContato\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(TipoContato tipocontato) throws Exception {
		String retorno;
		// Gravar o TipoContato no BD		
		try {

			TipoContato e = em.find(TipoContato.class, tipocontato.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "TipoContato Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando TipoContato\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<TipoContato> listar(String paramNome) throws Exception{		
		
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from TipoContato g");
		}
		else {
			q = em.createQuery("select g from TipoContato g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public TipoContato getObjectById(Long id) {

		return em.find(TipoContato.class, id);
	}
} // final da classe TipoContatoDao
