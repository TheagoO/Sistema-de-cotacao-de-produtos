package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.FornecedorPedidoCotacao;
import br.edu.unifacear.model.entity.PedidoCotacao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "pedidoCotacaoBean")
@ApplicationScoped
public class PedidoCotacaoController {
	
	private PedidoCotacao pedido;
	private PedidoCotacao selecionado;
	private Cotacao cotacao;
	private List<PedidoCotacao> lista;
	
	
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
			for (PedidoCotacao i : facade.listarPedidoCotacao()) {
				this.lista.add(i);
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
			String retorno = facade.editarPedidoCotacao(pedido);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
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
	
	public void onRowEdit(RowEditEvent<PedidoCotacao> event) {
		PedidoCotacao novo = new PedidoCotacao();

		for (PedidoCotacao i : this.lista) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
			}
		}

		if (event.getObject() != null) {
			try {
				this.pedido = novo;
				editar();
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
		List<FornecedorPedidoCotacao> fornecedor = new ArrayList<FornecedorPedidoCotacao>();
		fornecedor.add(new FornecedorPedidoCotacao(0, 1, new Fornecedor(0, "Thiago", null, null, null, null)));
		this.selecionado.setFornecedor(fornecedor);
		this.lista = new ArrayList<PedidoCotacao>();
		this.cotacao = new Cotacao();
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

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
		
}
