package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;
import br.edu.unifacear.model.entity.CotacaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "cotacaoItemBean")
@ApplicationScoped
public class CotacaoItemController {
	
	private CotacaoItem item;
	private CotacaoItem selecionado;
	private List<CotacaoItem> lista;
	private List<CotacaoItem> itens;
	private List<CotacaoFornecedorPreco> cotacaoFornecedor;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarCotacaoItem(item);
			this.item = new CotacaoItem();
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
			this.lista = facade.listarCotacaoItem("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar cotação dos itens"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarCotacaoItem(item);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação do item editado!"));
				listar();
			}
			this.item = new CotacaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cotação"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirCotacaoItem(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação do item deletado"));
			this.selecionado = new CotacaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir cotacão"));
			e.printStackTrace();
		}
	}
	
	public void listarItens(int id) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.itens = facade.listarItensCotacao(id);
			
			CotacaoItem ci = itens.get(0);
			
			listarCotacaoFornecedor(ci.getId());
			
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Itens listados"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar itens"));
			e.printStackTrace();
		}
		
	}
	
	
	public void listarCotacaoFornecedor(int id) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.cotacaoFornecedor = facade.listarCotacaoFornecedor(id);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Itens listados"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar itens"));
			e.printStackTrace();
		}
		
	}
	
	public void onRowEdit(RowEditEvent<CotacaoItem> event) {
		CotacaoItem novo = new CotacaoItem();

		for (CotacaoItem i : this.lista) {
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

	
	
	public void onRowCancel(RowEditEvent<CotacaoItem> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public CotacaoItemController() {
		this.item = new CotacaoItem();
		this.selecionado = new CotacaoItem();
		this.lista = new ArrayList<CotacaoItem>();
		this.itens = new ArrayList<CotacaoItem>();
		this.cotacaoFornecedor = new ArrayList<CotacaoFornecedorPreco>();
	}
	public CotacaoItem getItem() {
		return item;
	}
	public void setItem(CotacaoItem item) {
		this.item = item;
	}
	public List<CotacaoItem> getLista() {
		return lista;
	}
	public void setLista(List<CotacaoItem> lista) {
		this.lista = lista;
	}

	public CotacaoItem getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(CotacaoItem selecionado) {
		this.selecionado = selecionado;
	}

	public List<CotacaoItem> getItens() {
		return itens;
	}

	public void setItens(List<CotacaoItem> itens) {
		this.itens = itens;
	}

	public List<CotacaoFornecedorPreco> getCotacaoFornecedor() {
		return cotacaoFornecedor;
	}

	public void setCotacaoFornecedor(List<CotacaoFornecedorPreco> cotacaoFornecedor) {
		this.cotacaoFornecedor = cotacaoFornecedor;
	}
	
}
