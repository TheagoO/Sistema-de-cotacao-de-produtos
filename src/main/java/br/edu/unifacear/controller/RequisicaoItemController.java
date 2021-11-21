package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "requisicaoItemBean")
@SessionScoped
public class RequisicaoItemController {

	private RequisicaoItem item;
	private RequisicaoItem selecionado;
	private List<RequisicaoItem> lista;
	private List<RequisicaoItem> itens;

	public void salvar(Requisicao r, Almoxarifado a) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		r.setSolicitante(a);
		try {
			facade.salvarRequisicao(r, this.itens);
			fc.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Requisicao envida!"));
			listar();
			this.itens.clear();
		} catch (Exception e) {
			fc.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao Enviar requisicao!"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.clear();
		try {
			this.lista = facade.listarRequisicaoItem("");
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Lista atualizada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar Itens"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarRequisicaoItem(item);
			if (retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "PedidoCompra editado!"));
				listar();
			}
			this.item = new RequisicaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar PedidoCompra"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirRequisicaoItem(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido deletado"));
			this.selecionado = new RequisicaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir pedido"));
			e.printStackTrace();
		}
	}

	public void addItem(RequisicaoItem ri) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			this.selecionado = facade.pegarProduto(ri);
			this.itens.add(selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", ri.getProduto().getNome() + " adicionado"));
			this.selecionado = new RequisicaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao adicionar produto"));
			e.printStackTrace();
		}
		
		
	}
			
	public void onRowEdit(RowEditEvent<RequisicaoItem> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Quantidade editada!"));

	}

	public void onRowCancel(RowEditEvent<RequisicaoItem> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public void remover(RequisicaoItem ri) {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.itens.remove(ri);
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto removido!"));

	}
	
	public RequisicaoItemController() {
		this.item = new RequisicaoItem();
		this.selecionado = new RequisicaoItem();
		this.lista = new ArrayList<RequisicaoItem>();
		this.itens = new ArrayList<RequisicaoItem>();
		listar();
	}

	public RequisicaoItem getItem() {
		return item;
	}

	public void setItem(RequisicaoItem item) {
		this.item = item;
	}

	public RequisicaoItem getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(RequisicaoItem selecionado) {
		this.selecionado = selecionado;
	}

	public List<RequisicaoItem> getItens() {
		return itens;
	}

	public void setItens(List<RequisicaoItem> itens) {
		this.itens = itens;
	}

	public List<RequisicaoItem> getLista() {
		return lista;
	}

	public void setLista(List<RequisicaoItem> lista) {
		this.lista = lista;
	}


}
