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

public class PedidoCotacaoDao {
	EntityManager em = Connect.connection();
	public String salvar(PedidoCotacao pedidocotacao) throws Exception {
		String retorno;
		// Gravar o PedidoCotacao no BD

		try {			
			em.getTransaction().begin();
			em.persist(pedidocotacao);
			em.getTransaction().commit();		
			
			retorno = "PedidoCotacao Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando PedidoCotacao\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(PedidoCotacao pedidocotacao) throws Exception {
		String retorno;
		// Gravar o PedidoCotacao no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(pedidocotacao);
			em.getTransaction().commit();	
			
			retorno = "PedidoCotacao Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando PedidoCotacao\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(PedidoCotacao pedidocotacao) throws Exception {
		String retorno;
		// Gravar o PedidoCotacao no BD		
		try {

	
			PedidoCotacao e = em.find(PedidoCotacao.class, pedidocotacao.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "PedidoCotacao Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando PedidoCotacao\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<PedidoCotacao> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from PedidoCotacao g");
		}
		else {
			q = em.createQuery("select g from PedidoCotacao g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public PedidoCotacao getObjectById(Long id) {
	
		return em.find(PedidoCotacao.class, id);
	}
} // final da classe PedidoCotacaoDao
