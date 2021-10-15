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

public class ItemDao {

		EntityManager em = Connect.connection();
	public String salvar(Item item) throws Exception {
		String retorno;
		// Gravar o Item no BD
	
		try {			
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();		
			
			retorno = "Item Inserido com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Item\n"+e.getMessage());
		} finally {
			em.close();
		}
		return retorno;		
	} // salvar
	
	public String alterar(Item item) throws Exception {
		String retorno;
		// Gravar o Item no BD		
		try {
			
			
			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().commit();	
			
			retorno = "Item Alterado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Item\n"+e.getMessage());
		}
		return retorno;		
	} // alterar

	public String deletar(Item item) throws Exception {
		String retorno;
		// Gravar o Item no BD		
		try {


			Item e = em.find(Item.class, item.getId());
			em.getTransaction().begin();
			em.remove(e);
			
			retorno = "Item Deletado com Sucesso!";			
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Item\n"+e.getMessage());
		}
		return retorno;		
	} // deletar


	
	public List<Item> listar(String paramNome) throws Exception{		

		String cWhere = "";
		Query q = null;

		if(paramNome.equals("")) {
			q = em.createQuery("select g from Item g");
		}
		else {
			q = em.createQuery("select g from Item g"
					+" where nome like :nome");
			q.setParameter("nome", "%"+paramNome+"%");
		}
		
		return q.getResultList();		
	} //listar
	
	
	public Item getObjectById(Long id) {

		return em.find(Item.class, id);
	}
} // final da classe ItemDao