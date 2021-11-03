package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.entity.PedidoCompra;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "pedidoCompraBean")
@SessionScoped
public class PedidoCompraController {

	private PedidoCompra pedidodecompra;
	private Item selecionado;
	private List<PedidoCompra> pedidos;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			for(PedidoCompra p : pedidos) {
				facade.salvarPedidoCompra(p);
			}
			this.pedidos.removeAll(pedidos);
			this.pedidodecompra = new PedidoCompra();
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
			this.pedidodecompra = new PedidoCompra();
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
			this.pedidodecompra = new PedidoCompra();
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
		pedidodecompra = new PedidoCompra();
	}

	public void onRowEdit(RowEditEvent<PedidoCompra> event) {
		PedidoCompra novo = new PedidoCompra();

		for (PedidoCompra i : this.pedidos) {
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

	public void onRowCancel(RowEditEvent<PedidoCompra> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}

	public PedidoCompraController() {
		this.pedidodecompra = new PedidoCompra();
		this.selecionado = new Item();
		this.pedidos = new ArrayList<PedidoCompra>();
		listar();
	}

	public PedidoCompra getPedidodecompra() {
		return pedidodecompra;
	}

	public void setPedidodecompra(PedidoCompra pedidodecompra) {
		this.pedidodecompra = pedidodecompra;
	}

	public List<PedidoCompra> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoCompra> pedidos) {
		this.pedidos = pedidos;
	}

	public Item getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Item selecionado) {
		this.selecionado = selecionado;
	}

}
