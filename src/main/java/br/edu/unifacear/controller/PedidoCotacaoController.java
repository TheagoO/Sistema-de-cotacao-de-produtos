package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.ItemCotacao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.entity.PedidoCotacao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "pedidoCotacaoBean")
@ApplicationScoped
public class PedidoCotacaoController {

	private PedidoCotacao pedido;
	private PedidoCotacao pedidoSelecionado;
	private List<PedidoCotacao> listaPedidos;
	private List<CotacaoFornecedorPreco> listaCotacao;
	private CotacaoFornecedorPreco novaCotacao;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarPedidoCotacao(pedido);
			this.pedido = new PedidoCotacao();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido salvo!"));

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar pedido"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.listaPedidos.removeAll(listaPedidos);

		try {
			this.listaPedidos = facade.listarPedidoCotacao();

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar pedidos"));
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
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido editado!"));
				listar();
			}
			this.pedido = new PedidoCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar pedido"));
			e.printStackTrace();
		}
	}

	public void editarCotacao(int i) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			this.listaCotacao.remove(i);
			this.listaCotacao.add(i, novaCotacao);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotacão editada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cotação!"));
			e.printStackTrace();
		}

	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirPedidoCotacao(this.pedidoSelecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido deletado"));
			this.pedidoSelecionado = new PedidoCotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir produto"));
			e.printStackTrace();
		}
	}

	public String lancarCotacao() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			
			for(CotacaoFornecedorPreco cf : this.listaCotacao) {
				cf.setId(0);
				facade.salvarCotacaoFornecedor(cf);
			}
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação lançada!"));
			excluir();
			return "SUCESSO";
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao lançar cotação"));
			e.printStackTrace();
		}
		return null;
	}

	public void listarCotacoes() {
		GestaoFacade facade = new GestaoFacade();

		try {
			this.listaCotacao = facade.listarCotacaoFornecedor(this.pedidoSelecionado.getId());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void addItem() {

	}

	public void addFornecedor() {

	}

	public void onRowEdit(RowEditEvent<CotacaoFornecedorPreco> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		int i=0;
		for (CotacaoFornecedorPreco cf : listaCotacao) {
			if (cf.getId() == event.getObject().getId()) {
				this.novaCotacao = cf;
				
				break;
			}
			i++;
		}

		if (event.getObject() != null) {
			try {
				editarCotacao(i);
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
		this.pedidoSelecionado = new PedidoCotacao();
		this.listaPedidos = new ArrayList<PedidoCotacao>();
		this.listaCotacao = new ArrayList<CotacaoFornecedorPreco>();
		this.novaCotacao = new CotacaoFornecedorPreco();
		listar();
	}

	public PedidoCotacao getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCotacao pedido) {
		this.pedido = pedido;
	}

	public PedidoCotacao getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(PedidoCotacao pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public List<PedidoCotacao> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<PedidoCotacao> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<CotacaoFornecedorPreco> getListaCotacao() {
		return listaCotacao;
	}

	public void setListaCotacao(List<CotacaoFornecedorPreco> listaCotacao) {
		this.listaCotacao = listaCotacao;
	}

	public CotacaoFornecedorPreco getNovaCotacao() {
		return novaCotacao;
	}

	public void setNovaCotacao(CotacaoFornecedorPreco novaCotacao) {
		this.novaCotacao = novaCotacao;
	}

}
