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

public class NotaFiscalDao {
	EntityManager em = Connect.connection();
	public String salvar(NotaFiscal notafiscal) throws Exception {
		String retorno;
		// Gravar o NotaFiscal no BD

		try {			
			em.getTransaction().begin();
			em.persist(notafiscal);
			em.getTransaction().commit();		
			
			retorno = "NotaFiscal Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando NotaFiscal\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(NotaFiscal notafiscal) throws Exception {
		String retorno;
		// Gravar o NotaFiscal no BD		
		try {
			
			em.getTransaction().begin();
			em.merge(notafiscal);
			em.getTransaction().commit();	
			
			retorno = "NotaFiscal Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando NotaFiscal\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(NotaFiscal notafiscal) throws Exception {
		String retorno;
		// Gravar o NotaFiscal no BD		
		try {
			NotaFiscal e = em.find(NotaFiscal.class, notafiscal.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "NotaFiscal Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando NotaFiscal\n"+e.getMessage());
		}
		return retorno;		
	} // deletar


	
	public List<NotaFiscal> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from NotaFiscal g");
		}
		else {
			q = em.createQuery("select g from NotaFiscal g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public NotaFiscal getObjectById(Long id) {

		return em.find(NotaFiscal.class, id);
	}
} // final da classe NotaFiscalDao
