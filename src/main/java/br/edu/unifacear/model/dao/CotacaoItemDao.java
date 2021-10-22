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

public class CotacaoItemDao {
	EntityManager em = Connect.connection();

	public String salvar(CotacaoItem cotacaoitem) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD
		try {			
			em.getTransaction().begin();
			em.persist(cotacaoitem);
			em.getTransaction().commit();		
			
			retorno = "CotacaoItem Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando CotacaoItem\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(CotacaoItem cotacaoitem) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(cotacaoitem);
			em.getTransaction().commit();	
			
			retorno = "CotacaoItem Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando CotacaoItem\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(CotacaoItem cotacaoitem) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD		
		try {


			CotacaoItem e = em.find(CotacaoItem.class, cotacaoitem.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "CotacaoItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando CotacaoItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<CotacaoItem> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from CotacaoItem g");
		}
		else {
			q = em.createQuery("select g from CotacaoItem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar

	public CotacaoItem getObjectById(Long id) {
	
		return em.find(CotacaoItem.class, id);
	}
} // final da classe CotacaoItemDao
