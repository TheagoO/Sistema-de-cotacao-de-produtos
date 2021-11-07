package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Produto;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraItemBean")
@SessionScoped
public class OrdemCompraItemController {

	private RequisicaoItem pedidodecompra;
	private Produto selecionado;
	private List<RequisicaoItem> pedidos;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			for(RequisicaoItem p : pedidos) {
				facade.salvarPedidoCompra(p);
			}
			this.pedidos.removeAll(pedidos);
			this.pedidodecompra = new RequisicaoItem();
			fc.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Solicitação de Compra Enviada!"));
		} catch (Exception e) {
			fc.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao Enviar Solicitação de Compra!"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.pedidos.removeAll(pedidos);
		try {
			this.pedidos = facade.listarPedidoCompra("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar Itens"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarPedidoCompra(pedidodecompra);
			if (retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "PedidoCompra editado!"));
				listar();
			}
			this.pedidodecompra = new RequisicaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar PedidoCompra"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirPedidoCompra(this.pedidodecompra);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido deletado"));
			this.pedidodecompra = new RequisicaoItem();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir pedido"));
			e.printStackTrace();
		}
	}

	public void addItem(Almoxarifado a) {
		pedidodecompra.setAlmoxarifado(a);
		pedidodecompra.setNome(selecionado.getNome());
		pedidodecompra.setMarca(selecionado.getMarca());
		pedidodecompra.setCodigo(selecionado.getCodigo());
		this.pedidos.add(pedidodecompra);
		//pedidodecompra = new PedidoCompra();
	}

	public void onRowEdit(RowEditEvent<RequisicaoItem> event) {
		RequisicaoItem novo = new RequisicaoItem();

		for (RequisicaoItem i : this.pedidos) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
			}
		}

		if (event.getObject() != null) {
			try {
				this.pedidodecompra = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<RequisicaoItem> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}

	public OrdemCompraItemController() {
		this.pedidodecompra = new RequisicaoItem();
		this.selecionado = new Produto();
		this.pedidos = new ArrayList<RequisicaoItem>();
		listar();
	}

	public RequisicaoItem getPedidodecompra() {
		return pedidodecompra;
	}

	public void setPedidodecompra(RequisicaoItem pedidodecompra) {
		this.pedidodecompra = pedidodecompra;
	}

	public List<RequisicaoItem> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<RequisicaoItem> pedidos) {
		this.pedidos = pedidos;
	}

	public Produto getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Produto selecionado) {
		this.selecionado = selecionado;
	}

}
