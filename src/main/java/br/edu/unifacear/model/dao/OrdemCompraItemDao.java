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

public class OrdemCompraItemDao {
	EntityManager em = Connect.connection();
	public String salvar(OrdemCompraItem pedidoitem) throws Exception {
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
	
	public String alterar(OrdemCompraItem pedidoitem) throws Exception {
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

	public String deletar(OrdemCompraItem pedidoitem) throws Exception {
		String retorno;
		// Gravar o PedidoItem no BD		
		try {

		
			OrdemCompraItem e = em.find(OrdemCompraItem.class, pedidoitem.getId());
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

	
	public List<OrdemCompraItem> listar(long paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome == 0) {
			q = em.createQuery("select g from OrdemCompraItem g");
		}
		else {
			q = em.createQuery("select g from OrdemCompraItem g"
					+" where codigo like :codigo");
			q.setParameter("codigo", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public OrdemCompraItem getObjectById(Long id) {

		return em.find(OrdemCompraItem.class, id);
	}
} // final da classe PedidoItemDao
