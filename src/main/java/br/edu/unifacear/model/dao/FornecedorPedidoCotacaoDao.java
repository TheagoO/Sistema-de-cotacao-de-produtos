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

public class FornecedorPedidoCotacaoDao {
	EntityManager em = Connect.connection();

	public String salvar(FornecedorPedidoCotacao cotacaofornecedor) throws Exception {
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
	
	public String alterar(FornecedorPedidoCotacao cotacaofornecedor) throws Exception {
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

	public String deletar(FornecedorPedidoCotacao cotacaofornecedor) throws Exception {
		String retorno;
		// Gravar o CotacaoFornecedor no BD		
		try {

		
			FornecedorPedidoCotacao e = em.find(FornecedorPedidoCotacao.class, cotacaofornecedor.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "CotacaoFornecedor Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando CotacaoFornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<FornecedorPedidoCotacao> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from FornecedorPedidoCotacao g");
		}
		else {
			q = em.createQuery("select g from FornecedorPedidoCotacao g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	

	
	public FornecedorPedidoCotacao getObjectById(Long id) {

		return em.find(FornecedorPedidoCotacao.class, id);
	}
} // final da classe CotacaoFornecedorDao
