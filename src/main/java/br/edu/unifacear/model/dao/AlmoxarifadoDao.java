package br.edu.unifacear.model.dao;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.*;
import br.edu.unifacear.model.util.Connect;

import org.hibernate.Criteria;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class AlmoxarifadoDao {
		EntityManager em = Connect.connection();
	
	public String salvar(Almoxarifado almoxarifado) throws Exception {
		String retorno;
		List<Almoxarifado> list = listar(almoxarifado.getEmail());
		
		if(list.isEmpty()) {
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
		}else {
			return "E-mail já cadastrado";
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
			
			retorno = "Almoxarifado alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = "Erro alterando Almoxarifado";
			throw new Exception("Erro alterando Almoxarifado");
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
			em.getTransaction().commit();
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

		if(paramNome.equals("") || paramNome == null) {
			q = em.createQuery("select g from Almoxarifado g");
		}
		else {
			q = em.createQuery("select g from Almoxarifado g"
					+" where email like :email");
			q.setParameter("email", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	
	public Almoxarifado getObjectById(String email) {
		return em.find(Almoxarifado.class, email);
	}
} // final da classe AlmoxarifadoDao
