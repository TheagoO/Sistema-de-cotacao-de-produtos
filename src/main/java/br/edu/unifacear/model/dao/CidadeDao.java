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

public class CidadeDao {
	EntityManager em = Connect.connection();

	public String salvar(Cidade cidade) throws Exception {
		String retorno;
		// Gravar o Cidade no BD
		try {			
			em.getTransaction().begin();
			em.persist(cidade);
			em.getTransaction().commit();		
			
			retorno = "Cidade Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Cidade\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Cidade cidade) throws Exception {
		String retorno;
		// Gravar o Cidade no BD		
		try {
			
			em.getTransaction().begin();
			em.merge(cidade);
			em.getTransaction().commit();	
			
			retorno = "Cidade Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Cidade\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Cidade cidade) throws Exception {
		String retorno;
		// Gravar o Cidade no BD		
		try {

			Cidade e = em.find(Cidade.class, cidade.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Cidade Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Cidade\n"+e.getMessage());
		}
		return retorno;		
	} 
	public List<Cidade> listar(String paramNome) throws Exception{		
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Cidade g");
		}
		else {
			q = em.createQuery("select g from Cidade g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Cidade getObjectById(Long id) {
		return em.find(Cidade.class, id);
	}
} // final da classe CidadeDao
