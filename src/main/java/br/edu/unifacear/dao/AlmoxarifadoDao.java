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

public class AlmoxarifadoDao {
		EntityManager em = Connect.connection();
	
	public String salvar(Almoxarifado almoxarifado) throws Exception {
		String retorno;
		// Gravar o Almoxarifado no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(almoxarifado);
			em.getTransaction().commit();		
			
			retorno = "Almoxarifado Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Almoxarifado\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Almoxarifado almoxarifado) throws Exception {
		String retorno;
		// Gravar o Almoxarifado no BD		
		try {
			
			em.getTransaction().begin();
			em.merge(almoxarifado);
			em.getTransaction().commit();	
			
			retorno = "Almoxarifado Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Almoxarifado\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Almoxarifado almoxarifado) throws Exception {
		String retorno;
		// Gravar o Almoxarifado no BD		
		try {

			Almoxarifado e = em.find(Almoxarifado.class, almoxarifado.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Almoxarifado Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Almoxarifado\n"+e.getMessage());
		}
		return retorno;		
	} 
	
	public List<Almoxarifado> listar(String paramNome) throws Exception{		
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Almoxarifado g");
		}
		else {
			q = em.createQuery("select g from Almoxarifado g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	
	public Almoxarifado getObjectById(Long id) {
		return em.find(Almoxarifado.class, id);
	}
} // final da classe AlmoxarifadoDao
