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

public class CotacaoFornecedorDao {
	EntityManager em = Connect.connection();

	public String salvar(CotacaoFornecedor cotacaofornecedor) throws Exception {
		String retorno;
		// Gravar o CotacaoFornecedor no BD
		try {			
			em.getTransaction().begin();
			em.persist(cotacaofornecedor);
			em.getTransaction().commit();		
			
			retorno = "CotacaoFornecedor Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando CotacaoFornecedor\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(CotacaoFornecedor cotacaofornecedor) throws Exception {
		String retorno;
		// Gravar o CotacaoFornecedor no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(cotacaofornecedor);
			em.getTransaction().commit();	
			
			retorno = "CotacaoFornecedor Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando CotacaoFornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(CotacaoFornecedor cotacaofornecedor) throws Exception {
		String retorno;
		// Gravar o CotacaoFornecedor no BD		
		try {

		
			CotacaoFornecedor e = em.find(CotacaoFornecedor.class, cotacaofornecedor.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "CotacaoFornecedor Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando CotacaoFornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<CotacaoFornecedor> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from CotacaoFornecedor g");
		}
		else {
			q = em.createQuery("select g from CotacaoFornecedor g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	

	
	public CotacaoFornecedor getObjectById(Long id) {

		return em.find(CotacaoFornecedor.class, id);
	}
} // final da classe CotacaoFornecedorDao
