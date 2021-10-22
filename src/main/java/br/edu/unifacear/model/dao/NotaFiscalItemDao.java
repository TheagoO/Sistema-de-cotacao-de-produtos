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

public class NotaFiscalItemDao {
	EntityManager em = Connect.connection();
	public String salvar(NotaFiscalItem notafiscalitem) throws Exception {
		String retorno;

		try {			
			em.getTransaction().begin();
			em.persist(notafiscalitem);
			em.getTransaction().commit();		
			
			retorno = "NotaFiscalItem Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando NotaFiscalItem\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(NotaFiscalItem notafiscalitem) throws Exception {
		String retorno;
		// Gravar o NotaFiscalItem no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(notafiscalitem);
			em.getTransaction().commit();	
			
			retorno = "NotaFiscalItem Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando NotaFiscalItem\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(NotaFiscalItem notafiscalitem) throws Exception {
		String retorno;
		// Gravar o NotaFiscalItem no BD		
		try {

		
			NotaFiscalItem e = em.find(NotaFiscalItem.class, notafiscalitem.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "NotaFiscalItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando NotaFiscalItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<NotaFiscalItem> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from NotaFiscalItem g");
		}
		else {
			q = em.createQuery("select g from NotaFiscalItem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	
	public NotaFiscalItem getObjectById(Long id) {

		return em.find(NotaFiscalItem.class, id);
	}
} // final da classe NotaFiscalItemDao
