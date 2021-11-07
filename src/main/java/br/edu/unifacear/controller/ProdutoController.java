package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Produto;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ProdutoController {

	private Produto item;
	private Produto selecionado;
	private List<Produto> itens;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarItem(item);
			this.item = new Produto();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto salvo!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar produto"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.itens.removeAll(itens);
		try {
			for (Produto i : facade.listarItens()) {
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
			String retorno = facade.editarItem(item);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto editado!"));
				listar();
			}
			this.item = new Produto();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar produto"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirItem(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto deletado"));
			this.selecionado = new Produto();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir produto"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<Produto> event) {
		Produto novo = new Produto();

		for (Produto i : this.itens) {
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

	public void onRowCancel(RowEditEvent<Produto> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}

	public ProdutoController() {
		this.item = new Produto();
		this.itens = new ArrayList<Produto>();
		this.selecionado = new Produto();
		listar();
	}

	public Produto getItem() {
		return item;
	}

	public void setItem(Produto item) {
		this.item = item;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public Produto getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Produto selecionado) {
		this.selecionado = selecionado;
	}

}
