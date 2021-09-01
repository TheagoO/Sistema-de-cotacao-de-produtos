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

public class PedidoCompraDao {
	EntityManager em = Connect.connection();
	public String salvar(PedidoCompra pedidocompra) throws Exception {
		String retorno;
		// Gravar o PedidoCompra no BD
		
		try {			
			em.getTransaction().begin();
			em.persist(pedidocompra);
			em.getTransaction().commit();		
			
			retorno = "PedidoCompra Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando PedidoCompra\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(PedidoCompra pedidocompra) throws Exception {
		String retorno;
		// Gravar o PedidoCompra no BD		
		try {
			
	
			em.getTransaction().begin();
			em.merge(pedidocompra);
			em.getTransaction().commit();	
			
			retorno = "PedidoCompra Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando PedidoCompra\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(PedidoCompra pedidocompra) throws Exception {
		String retorno;
		// Gravar o PedidoCompra no BD		
		try {

			PedidoCompra e = em.find(PedidoCompra.class, pedidocompra.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "PedidoCompra Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoCompra\n"+e.getMessage());
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
} // final da classe PedidoCompraDao
