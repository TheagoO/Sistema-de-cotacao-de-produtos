package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.ItemCotacao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "itemContacaoBean")
@ApplicationScoped
public class ItemCotacaoController {
	
	private ItemCotacao item;
	private ItemCotacao selecionado;
	private List<ItemCotacao> lista;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarItemCotacao(item);
			this.item = new ItemCotacao();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação do item salvo!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar produto"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarItemCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar cotação dos itens"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarItemCotacao(item);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação do item editado!"));
				listar();
			}
			this.item = new ItemCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cotação"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirItemCotacao(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação do item deletado"));
			this.selecionado = new ItemCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir cotacão"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<ItemCotacao> event) {
		ItemCotacao novo = new ItemCotacao();

		for (ItemCotacao i : this.lista) {
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

	public void onRowCancel(RowEditEvent<ItemCotacao> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public ItemCotacaoController() {
		this.item = new ItemCotacao();
		this.selecionado = new ItemCotacao();
		this.lista = new ArrayList<ItemCotacao>();
	}
	public ItemCotacao getItem() {
		return item;
	}
	public void setItem(ItemCotacao item) {
		this.item = item;
	}
	public List<ItemCotacao> getLista() {
		return lista;
	}
	public void setLista(List<ItemCotacao> lista) {
		this.lista = lista;
	}
	
}
