package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Produto;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "requisicaoBean")
@ApplicationScoped
public class RequisicaoController {
	
	private Requisicao requisicao;
	private Requisicao selecionado;
	private List<Requisicao> lista;
	private List<RequisicaoItem> itens;
	
	public void salvar(Almoxarifado a) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		this.requisicao.setSolicitante(a);
		try {
			facade.salvarRequisicao(requisicao, null);
			this.requisicao = new Requisicao();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Solicitação de Compra enviada!"));
			listar();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao enviar solicitação"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarRequisicao(0);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Lista atualizada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Nenhum registro de requisição encontrado!"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarRequisicao(requisicao);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Requisicao de compra alterado!"));
				listar();
			}
			this.requisicao = new Requisicao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao alterar requisicao de compra"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirRequisicao(this.requisicao);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Requisicao de compra excluida"));
			this.requisicao = new Requisicao();
			listar();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir requisicao de compra"));
			e.printStackTrace();
		}
	}
	
	public void listarItens(Requisicao r) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.itens = facade.listarItens(r);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Nenhum registro de item encontrado"));
			e.printStackTrace();
		}
		
	}
		
	public void onRowEdit(RowEditEvent<Requisicao> event) {
		Requisicao novo = new Requisicao();

		for (Requisicao i : this.lista) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
			}
		}

		if (event.getObject() != null) {
			try {
				this.requisicao = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Requisicao> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public RequisicaoController() {
		this.requisicao = new Requisicao();
		this.lista = new ArrayList<Requisicao>();
		this.selecionado = new Requisicao();
		this.itens = new ArrayList<RequisicaoItem>();
		listar();
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public Requisicao getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Requisicao selecionado) {
		this.selecionado = selecionado;
	}

	public List<Requisicao> getLista() {
		return lista;
	}

	public void setLista(List<Requisicao> lista) {
		this.lista = lista;
	}

	public List<RequisicaoItem> getItens() {
		return itens;
	}

	public void setItens(List<RequisicaoItem> itens) {
		this.itens = itens;
	}

}
