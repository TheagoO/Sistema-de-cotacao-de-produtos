package br.edu.unifacear.model.dao;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.*;
import br.edu.unifacear.model.util.Connect;

public class FornecedorDao {
	EntityManager em = Connect.connection();

	public String salvar(Fornecedor fornecedor) throws Exception {
		String retorno;
		
		if(listar(fornecedor.getCnpj()).isEmpty()) {
			try {			
				em.getTransaction().begin();
				em.persist(fornecedor);
				em.getTransaction().commit();		
				
				retorno = "Fornecedor Inserido com Sucesso!";			
			} catch (Exception e) {
				retorno = e.getMessage();
				throw new Exception("Erro Gravando Fornecedor\n"+e.getMessage());
			} finally {
				em.close();
			}
		}else {
			return "CNPJ já cadastrado";
		}
		
		return retorno;		
	} // salvar
	
	public String alterar(Fornecedor fornecedor) throws Exception {
		String retorno;
		// Gravar o Fornecedor no BD		
		try {
			
			
			em.getTransaction().begin();
			em.merge(fornecedor);
			em.getTransaction().commit();	
			
			retorno = "Fornecedor Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Fornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Fornecedor fornecedor) throws Exception {
		String retorno;
		// Gravar o Fornecedor no BD		
		try {

			Fornecedor e = em.find(Fornecedor.class, fornecedor.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "Fornecedor Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Fornecedor\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<Fornecedor> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Fornecedor g");
		}
		else {
			int i = Integer.parseInt(paramNome);
			q = em.createQuery("select g from Fornecedor g"
					+" where id = :id");
			q.setParameter("id", i);
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Fornecedor getObjectById(Long id) {
	
		return em.find(Fornecedor.class, id);
	}
} // final da classe FornecedorDao
