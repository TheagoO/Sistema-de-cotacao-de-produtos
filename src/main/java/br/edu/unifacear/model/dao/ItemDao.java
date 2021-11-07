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

public class ItemDao {

	EntityManager em = Connect.connection();

	public String salvar(Produto item) throws Exception {
		String retorno;
		// Gravar o Item no BD

		try {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();

			retorno = "Item Inserido com Sucesso!";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Gravando Item\n" + e.getMessage());
		} finally {
			em.close();
		}
		return retorno;
	} // salvar

	public String alterar(Produto item) throws Exception {
		String retorno;
		// Gravar o Item no BD
		try {

			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().commit();

			retorno = "Item Alterado com Sucesso!";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Alterando Item\n" + e.getMessage());
		}
		return retorno;
	} // alterar

	public String deletar(Produto item) throws Exception {
		String retorno;
		// Gravar o Item no BD
		try {

			Produto e = em.find(Produto.class, item.getId());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			retorno = "Item Deletado com Sucesso!";
		} catch (Exception e) {
			retorno = e.getMessage();
			throw new Exception("Erro Deletando Item\n" + e.getMessage());
		}
		return retorno;
	} // deletar

	public List<Produto> listar(String paramNome) throws Exception {

		String cWhere = "";
		Query q = null;

		if (paramNome.equals("")) {
			q = em.createQuery("select g from Item g");
		} else {
			q = em.createQuery("select g from Item g" + " where nome like :nome");
			q.setParameter("nome", "%" + paramNome + "%");
		}

		return q.getResultList();
	} // listar

	public Produto getObjectByName(String nome) {
		return em.find(Produto.class, nome);
	}
} // final da classe ItemDao
