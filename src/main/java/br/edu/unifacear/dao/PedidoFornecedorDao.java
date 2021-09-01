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

public class PedidoFornecedorDao {
	EntityManager em = Connect.connection();
	public String salvar(PedidoFornecedor pedidoforn) throws Exception {
		String retorno;
		// Gravar o PedidoFornecedor no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(pedidoforn);
			em.getTransaction().commit();		
			
			retorno = "PedidoFornecedor Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando PedidoFornecedor\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(PedidoFornecedor pedidoforn) throws Exception {
		String retorno;
		// Gravar o PedidoFornecedor no BD		
		try {
			
			
			em.getTransaction().begin();
			em.merge(pedidoforn);
			em.getTransaction().commit();	
			
			retorno = "PedidoFornecedor Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando PedidoFornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(PedidoFornecedor pedidoforn) throws Exception {
		String retorno;
		// Gravar o PedidoFornecedor no BD		
		try {

		
			PedidoFornecedor e = em.find(PedidoFornecedor.class, pedidoforn.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "PedidoFornecedor Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoFornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<PedidoFornecedor> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from PedidoFornecedor g");
		}
		else {
			q = em.createQuery("select g from PedidoFornecedor g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	public PedidoFornecedor getObjectById(Long id) {

		return em.find(PedidoFornecedor.class, id);
	}
} // final da classe PedidoFornecedorDao
