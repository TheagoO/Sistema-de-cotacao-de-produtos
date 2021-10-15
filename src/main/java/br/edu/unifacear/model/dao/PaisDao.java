package br.edu.unifacear.model.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.Pais;
import br.edu.unifacear.model.util.Connect;

public class PaisDao {
	
	EntityManager em = Connect.connection();
	
	public String salvar(Pais pais) throws Exception {
		String retorno;
		// Gravar o Pais no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(pais);
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
	
	public String alterar(Pais pais) throws Exception {
		String retorno;
		// Gravar o Pais no BD		
		try {

			em.getTransaction().begin();
			em.merge(pais);
			em.getTransaction().commit();	
			
			retorno = "Pais Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Pais\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Pais pais) throws Exception {
		String retorno;
		// Gravar o Pais no BD		
		try {

	
			Pais e = em.find(Pais.class, pais.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Pais Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Pais\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<Pais> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Pais g");
		}
		else {
			q = em.createQuery("select g from Pais g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Pais getObjectById(Long id) {
	
		return em.find(Pais.class, id);
	}
	
}
