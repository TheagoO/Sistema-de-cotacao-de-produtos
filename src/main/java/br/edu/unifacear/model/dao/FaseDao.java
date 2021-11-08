package br.edu.unifacear.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.Fase;
import br.edu.unifacear.model.util.Connect;

public class FaseDao {
	EntityManager em = Connect.connection();

	public String salvar(Fase status) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD
		try {			
			em.getTransaction().begin();
			em.persist(status);
			em.getTransaction().commit();		
			
			retorno = "Status Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Status\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Fase status) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(status);
			em.getTransaction().commit();	
			
			retorno = "Status Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Status\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Fase status) throws Exception {
		String retorno;
		// Gravar o CotacaoItem no BD		
		try {


			Fase e = em.find(Fase.class, status.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "Status Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Status\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	public List<Fase> listar(int paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome == 0) {
			q = em.createQuery("select g from Fase g");
		}
		else {
			q = em.createQuery("select g from Fase g"
					+" where status like :status");
			q.setParameter("status", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar

	public Fase getObjectById(Long id) {
	
		return em.find(Fase.class, id);
	}
}
