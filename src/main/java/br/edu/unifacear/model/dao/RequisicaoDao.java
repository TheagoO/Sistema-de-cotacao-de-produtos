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

public class RequisicaoDao {
	EntityManager em = Connect.connection();
	public String salvar(Requisicao pedidocompra) throws Exception {
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
	
	public String alterar(Requisicao pedidocompra) throws Exception {
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

	public String deletar(Requisicao pedidocompra) throws Exception {
		String retorno;
		// Gravar o PedidoCompra no BD		
		try {

			Requisicao e = em.find(Requisicao.class, pedidocompra.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "PedidoCompra Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoCompra\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<Requisicao> listar(long paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome==0) {
			q = em.createQuery("select g from Requisicao g");
		}
		else {
			q = em.createQuery("select g from Requisicao g"
					+" where codigo like :codigo");
			q.setParameter("codigo", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Requisicao getObjectById(Long id) {

		return em.find(Requisicao.class, id);
	}
} // final da classe PedidoCompraDao
