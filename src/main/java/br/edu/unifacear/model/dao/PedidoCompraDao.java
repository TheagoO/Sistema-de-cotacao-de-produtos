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

public class PedidoCompraDao {
	EntityManager em = Connect.connection();
	public String salvar(PedidoCompra pedidoitem) throws Exception {
		String retorno;
		// Gravar o PedidoItem no BD

		try {			
			em.getTransaction().begin();
			em.persist(pedidoitem);
			em.getTransaction().commit();		
			
			retorno = "PedidoItem Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando PedidoItem\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(PedidoCompra pedidoitem) throws Exception {
		String retorno;
		// Gravar o PedidoItem no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(pedidoitem);
			em.getTransaction().commit();	
			
			retorno = "PedidoItem Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando PedidoItem\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(PedidoCompra pedidoitem) throws Exception {
		String retorno;
		// Gravar o PedidoItem no BD		
		try {

		
			PedidoCompra e = em.find(PedidoCompra.class, pedidoitem.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "PedidoItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<PedidoCompra> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from PedidoCompra g");
		}
		else {
			q = em.createQuery("select g from PedidoCompra g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public PedidoCompra getObjectById(Long id) {

		return em.find(PedidoCompra.class, id);
	}
} // final da classe PedidoItemDao
