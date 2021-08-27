package br.edu.unifacear.entity;

import java.util.Arrays;

public class PedidoCompra {
	
	private int id;
	private int status;
	
	private PedidoFornecedor[] pedido;

	public PedidoCompra() {
		
	}
	
	public PedidoCompra(int id, int status, PedidoFornecedor[] pedido) {
		super();
		this.id = id;
		this.status = status;
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public PedidoFornecedor[] getPedido() {
		return pedido;
	}

	public void setPedido(PedidoFornecedor[] pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "PedidoCompra [id=" + id + ", status=" + status + ", pedido=" + Arrays.toString(pedido) + "]";
	}
	
	
}
