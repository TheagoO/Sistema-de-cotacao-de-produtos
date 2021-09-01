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

public class FiscalItemDao {
	EntityManager em = Connect.connection();

	public String salvar(FiscalItem fiscalitem) throws Exception {
		String retorno;
		// Gravar o FiscalItem no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(fiscalitem);
			em.getTransaction().commit();		
			
			retorno = "FiscalItem Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando FiscalItem\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(FiscalItem fiscalitem) throws Exception {
		String retorno;
		// Gravar o FiscalItem no BD		
		try {

			em.getTransaction().begin();
			em.merge(fiscalitem);
			em.getTransaction().commit();	
			
			retorno = "FiscalItem Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando FiscalItem\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(FiscalItem fiscalitem) throws Exception {
		String retorno;
		// Gravar o FiscalItem no BD		
		try {

	
			FiscalItem e = em.find(FiscalItem.class, fiscalitem.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "FiscalItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando FiscalItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<FiscalItem> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from FiscalItem g");
		}
		else {
			q = em.createQuery("select g from FiscalItem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public FiscalItem getObjectById(Long id) {
	
		return em.find(FiscalItem.class, id);
	}
} // final da classe FiscalItemDao
