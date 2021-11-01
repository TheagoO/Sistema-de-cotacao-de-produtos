package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.FornecedorPedidoCotacao;
import br.edu.unifacear.model.entity.ItemCotacao;
import br.edu.unifacear.model.entity.PedidoCotacao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "pedidoCotacaoBean")
@ApplicationScoped
public class PedidoCotacaoController {

	private PedidoCotacao pedido;
	private PedidoCotacao selecionado;
	private List<PedidoCotacao> lista;
	private List<ItemCotacao> itens;
	private List<Fornecedor> fornecedores;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarPedidoCotacao(pedido);
			this.pedido = new PedidoCotacao();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto salvo!"));
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
			this.lista = facade.listarPedidoCotacao();
			List<FornecedorPedidoCotacao> pc = facade.listarFornecedorPedidoCotacao();
			this.fornecedores.removeAll(fornecedores);
			for (FornecedorPedidoCotacao f : pc) {
				this.fornecedores.add(f.getFornecedor());
			}
			this.itens.removeAll(itens);
			this.itens = facade.listarItemCotacao();
			
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar produtos"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarPedidoCotacao(pedido);
			if (retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto editado!"));
				listar();
			}
			this.pedido = new PedidoCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar produto"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirPedidoCotacao(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Produto deletado"));
			this.selecionado = new PedidoCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir produto"));
			e.printStackTrace();
		}
	}
	
	public void lancarCotacao() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarCotacao(null, itens);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação lançada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao lançar cotação"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<ItemCotacao> event) {
		ItemCotacao novo = new ItemCotacao();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		for (ItemCotacao i : this.itens) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
				this.itens.remove(i);
				break;
			}
		}

		if (event.getObject() != null) {
			try {
				
				this.itens.add(novo);
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Valor alterado!"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<PedidoCotacao> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}

	public PedidoCotacaoController() {
		this.pedido = new PedidoCotacao();
		this.selecionado = new PedidoCotacao();
		this.lista = new ArrayList<PedidoCotacao>();
		this.itens = new ArrayList<ItemCotacao>();
		this.fornecedores = new ArrayList<Fornecedor>();
		listar();
	}

	public PedidoCotacao getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCotacao pedido) {
		this.pedido = pedido;
	}

	public PedidoCotacao getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(PedidoCotacao selecionado) {
		this.selecionado = selecionado;
	}

	public List<PedidoCotacao> getLista() {
		return lista;
	}

	public void setLista(List<PedidoCotacao> lista) {
		this.lista = lista;
	}

	public List<ItemCotacao> getItens() {
		return itens;
	}

	public void setItens(List<ItemCotacao> itens) {
		this.itens = itens;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
