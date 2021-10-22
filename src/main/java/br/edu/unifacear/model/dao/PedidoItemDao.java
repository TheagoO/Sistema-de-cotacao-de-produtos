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

public class PedidoItemDao {
	EntityManager em = Connect.connection();
	public String salvar(PedidoItem pedidoitem) throws Exception {
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
	
	public String alterar(PedidoItem pedidoitem) throws Exception {
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

	public String deletar(PedidoItem pedidoitem) throws Exception {
		String retorno;
		// Gravar o PedidoItem no BD		
		try {

		
			PedidoItem e = em.find(PedidoItem.class, pedidoitem.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "PedidoItem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoItem\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<PedidoItem> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from PedidoItem g");
		}
		else {
			q = em.createQuery("select g from PedidoItem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public PedidoItem getObjectById(Long id) {

		return em.find(PedidoItem.class, id);
	}
} // final da classe PedidoItemDao
