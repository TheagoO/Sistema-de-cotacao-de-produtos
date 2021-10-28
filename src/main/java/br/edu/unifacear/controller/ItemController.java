package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemController {

	private Item item;
	private List<Item> itens;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarItem(item);
			this.item = new Item();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto salvo!"));
		} catch (Exception e) {
			fc.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar produto"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.itens.removeAll(itens);
		try {
			for (Item i : facade.listarItens()) {
				this.itens.add(i);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar produtos"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.editarItem(item);
			listar();
			this.item = new Item();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto editado!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar produto"));
			e.printStackTrace();
		}
	}

	public void onRowEdit(RowEditEvent<Item> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Item novo = new Item();

		for (Item i : this.itens) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
			}
		}

		if (event.getObject() != null) {
			try {
				this.item = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Item> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CANCELADO", "Edição cancelada!"));
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
