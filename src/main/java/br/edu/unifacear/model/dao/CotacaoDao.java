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

public class CotacaoDao {
	EntityManager em = Connect.connection();

	public String salvar(Cotacao cotacao) throws Exception {
		String retorno;
		// Gravar o Cotacao no BD
		
		try {			
			em.getTransaction().begin();
			em.persist(cotacao);
			em.getTransaction().commit();		
			
			retorno = "Cotacao Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Cotacao\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Cotacao cotacao) throws Exception {
		String retorno;
		// Gravar o Cotacao no BD		
		try {
	
			em.getTransaction().begin();
			em.merge(cotacao);
			em.getTransaction().commit();	
			
			retorno = "Cotacao Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Cotacao\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Cotacao cotacao) throws Exception {
		String retorno;
		// Gravar o Cotacao no BD		
		try {


			Cotacao e = em.find(Cotacao.class, cotacao.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "Cotacao Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Cotacao\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<Cotacao> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Cotacao g");
		}
		else {
			q = em.createQuery("select g from Cotacao g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Cotacao getObjectById(Long id) {
		
		return em.find(Cotacao.class, id);
	}
} // final da classe CotacaoDao
