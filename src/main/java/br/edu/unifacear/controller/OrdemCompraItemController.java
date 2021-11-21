package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.OrdemCompraItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraItemBean")
@ApplicationScoped
public class OrdemCompraItemController {

	private OrdemCompraItem item;
	private OrdemCompraItem selecionado;
	private List<OrdemCompraItem> lista;
	private List<OrdemCompraItem> itens;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			facade.salvarOrdemCompraItem(item);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Item adicionado!"));
			this.item = new OrdemCompraItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao adicionar item!"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarOrdemCompraItem(0);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Nenhum registro de iten encontrado!"));
			e.printStackTrace();
		}

	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarOrdemCompraItem(item);
			if (retorno.contains("Nome em branco") || retorno.contains("E-mail em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Item alterado!"));
				listar();
			}
			this.item = new OrdemCompraItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao alterar item!"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirOrdemCompraItem(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Item excluido!"));
			listar();
			this.selecionado = new OrdemCompraItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir item!"));
			e.printStackTrace();
		}
	}
	
	public void listarItens(int oc) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			this.itens = facade.listarItensCompra(oc);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Nenhum registro de iten encontrado!"));
			e.printStackTrace();
		}
	}
	
	public OrdemCompraItemController() {
		this.item = new OrdemCompraItem();
		this.selecionado = new OrdemCompraItem();
		this.lista = new ArrayList<OrdemCompraItem>();
		this.itens = new ArrayList<OrdemCompraItem>();
		listar();
	}

	public OrdemCompraItem getItem() {
		return item;
	}

	public void setItem(OrdemCompraItem item) {
		this.item = item;
	}

	public OrdemCompraItem getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(OrdemCompraItem selecionado) {
		this.selecionado = selecionado;
	}

	public List<OrdemCompraItem> getLista() {
		return lista;
	}

	public void setLista(List<OrdemCompraItem> lista) {
		this.lista = lista;
	}

	public List<OrdemCompraItem> getItens() {
		return itens;
	}

	public void setItens(List<OrdemCompraItem> itens) {
		this.itens = itens;
	}
	
	
}
