package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.facade.GestaoFacade;


@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemController {

	private Item item;
	private List<Item> itens;

	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarItem(item);
			this.item = new Item();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item salvo com sucesso!", "SUCESSO"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar item", e.getMessage()));
			e.printStackTrace();
		}
		return "Sucesso!";
	}
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			for(Item i : facade.listarItens()) {
				this.itens.add(i);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar itens", "ERROR"));
			e.printStackTrace();
		}
	}
	
	public ItemController() {
		this.item = new Item();
		this.itens = new ArrayList<Item>();
		listar();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
