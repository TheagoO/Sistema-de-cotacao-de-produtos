package br.edu.unifacear.model.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.Origem;
import br.edu.unifacear.model.util.Connect;

public class OrigemDao {
	
	EntityManager em = Connect.connection();
	
	public String salvar(Origem origem) throws Exception {
		String retorno;
		// Gravar o Pais no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(origem);
			em.getTransaction().commit();		
			
			retorno = "Pais Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Pais\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Origem origem) throws Exception {
		String retorno;
		// Gravar o Pais no BD		
		try {

			em.getTransaction().begin();
			em.merge(origem);
			em.getTransaction().commit();	
			
			retorno = "Pais Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Pais\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Origem origem) throws Exception {
		String retorno;
		// Gravar o Pais no BD		
		try {

	
			Origem e = em.find(Origem.class, origem.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Origem Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Pais\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<Origem> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Origem g");
		}
		else {
			q = em.createQuery("select g from Origem g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Origem getObjectById(Long id) {
	
		return em.find(Origem.class, id);
	}
	
}
