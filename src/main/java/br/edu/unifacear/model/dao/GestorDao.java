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

public class GestorDao {

		EntityManager em = Connect.connection();
	public String salvar(Gestor gestor) throws Exception {
		String retorno;
		List<Gestor> list = listar(gestor.getEmail());
		
		if(list.isEmpty()) {
			try {			
				em.getTransaction().begin();
				em.persist(gestor);
				em.getTransaction().commit();		
				
				retorno = "Gestor Inserido com Sucesso!";			
			} catch (Exception e) {
				retorno = e.getMessage();
				throw new Exception("Erro Gravando Gestor\n"+e.getMessage());
			} finally {
				em.close();
			}
		}else {
			return "E-mail já cadastrado";
		}
		
		
		return retorno;		
	} // salvar
	
	public String alterar(Gestor gestor) throws Exception {
		String retorno;
		// Gravar o Gestor no BD		
		try {
			

			em.getTransaction().begin();
			em.merge(gestor);
			em.getTransaction().commit();	
			
			retorno = "Gestor Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Gestor\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Gestor gestor) throws Exception {
		String retorno;
		// Gravar o Gestor no BD		
		try {

		
			Gestor e = em.find(Gestor.class, gestor.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Gestor Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Gestor\n"+e.getMessage());
		}
		return retorno;		
	} // deletar

	
	
	public List<Gestor> listar(String paramNome) throws Exception{		
	
		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Gestor g");
		}
		else {
			q = em.createQuery("select g from Gestor g"
					+" where email like :email");
			q.setParameter("email", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
		
	public Gestor getObjectById(Long id) {
	
		return em.find(Gestor.class, id);
	}
} // final da classe GestorDao
