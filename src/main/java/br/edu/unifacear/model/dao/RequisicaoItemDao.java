package br.edu.unifacear.model.dao;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.*;
import br.edu.unifacear.model.util.Connect;


public class RequisicaoItemDao {
	EntityManager em = Connect.connection();
	public String salvar(RequisicaoItem RequisicaoItem) throws Exception {
		String retorno;
		// Gravar o RequisicaoItem no BD
		
		try {			
			em.getTransaction().begin();
			em.persist(RequisicaoItem);
			em.getTransaction().commit();		
			
			retorno = "RequisicaoItem Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando RequisicaoItem\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(RequisicaoItem RequisicaoItem) throws Exception {
		String retorno;
		// Gravar o RequisicaoItem no BD		
		try {
			
	
			em.getTransaction().begin();
			em.merge(RequisicaoItem);
			em.getTransaction().commit();	
			
			retorno = "RequisicaoItem Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando RequisicaoItem\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(RequisicaoItem RequisicaoItem) throws Exception {
		String retorno;
		// Gravar o RequisicaoItem no BD		
		try {

			RequisicaoItem e = em.find(RequisicaoItem.class, RequisicaoItem.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "RequisicaoItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando RequisicaoItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<RequisicaoItem> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from RequisicaoItem g");
		}
		else {
			q = em.createQuery("select g from RequisicaoItem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public RequisicaoItem getObjectById(Long id) {

		return em.find(RequisicaoItem.class, id);
	}
} // final da classe RequisicaoItemDao
