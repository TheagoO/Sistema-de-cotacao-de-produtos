package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.OrdemCompraItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraBean")
@ApplicationScoped
public class OrdemCompraController {

	private OrdemCompra ordemCompra;
	private OrdemCompra ordemSelecionada;
	private List<OrdemCompra> lista;
	private List<OrdemCompra> aprovados;
	private List<OrdemCompraItem> itens;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			facade.salvarOrdemCompra(ordemCompra);
			this.ordemCompra = new OrdemCompra();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido salvo!"));

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar ordemCompra"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);

		try {
			this.lista = facade.listarOrdemCompra("");

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar ordemCompras"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarOrdemCompra(ordemCompra);
			if (retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido editado!"));
				listar();
			}
			this.ordemCompra = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar ordemCompra"));
			e.printStackTrace();
		}
	}


	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirOrdemCompra(this.ordemSelecionada);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido deletado"));
			this.ordemSelecionada = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir produto"));
			e.printStackTrace();
		}
	}
	
	public void negar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			this.ordemSelecionada.getFase().setStatus(0);
			facade.editarOrdemCompra(ordemSelecionada);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra negada!"));
			this.ordemSelecionada = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao negar ordem de compra"));
			e.printStackTrace();
		}
	}
	
	
	public void listarAprovados() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.aprovados.removeAll(aprovados);
		try {
			this.aprovados = facade.listarOrdemCompra("Aprovados");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar aprovados"));
			e.printStackTrace();
		}
		
	}
	
	
	public void listarItens(OrdemCompra oc) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.itens = facade.listarItens(oc);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar itens"));
			e.printStackTrace();
		}	
	}
	
	
	public OrdemCompraController() {
		this.ordemCompra = new OrdemCompra();
		this.ordemSelecionada = new OrdemCompra();
		this.lista = new ArrayList<OrdemCompra>();
		this.aprovados = new ArrayList<OrdemCompra>();
		this.itens = new ArrayList<OrdemCompraItem>();
		listar();
		listarAprovados();
	}

	public OrdemCompra getOrdemCompra() {
		return ordemCompra;
	}

	public void setOrdemCompra(OrdemCompra ordemCompra) {
		this.ordemCompra = ordemCompra;
	}

	public OrdemCompra getOrdemSelecionada() {
		return ordemSelecionada;
	}

	public void setOrdemSelecionada(OrdemCompra ordemSelecionada) {
		this.ordemSelecionada = ordemSelecionada;
	}

	public List<OrdemCompra> getLista() {
		return lista;
	}

	public void setLista(List<OrdemCompra> lista) {
		this.lista = lista;
	}

	public List<OrdemCompra> getAprovados() {
		return aprovados;
	}

	public void setAprovados(List<OrdemCompra> aprovados) {
		this.aprovados = aprovados;
	}

	public List<OrdemCompraItem> getItens() {
		return itens;
	}

	public void setItens(List<OrdemCompraItem> itens) {
		this.itens = itens;
	}

}
