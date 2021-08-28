package br.edu.unifacear.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class PedidoCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STATUS")
	private int status;
	
	@OneToMany
	private List<PedidoFornecedor> pedido = new ArrayList<>();

	public PedidoCompra() {
		this.pedido = new ArrayList<>();
	}
	
	
	public PedidoCompra(int id, int status, List<PedidoFornecedor> pedido) {
		super();
		this.pedido = new ArrayList<>();
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


	public PedidoFornecedor getPedido(int i) {
		return pedido.get(i);
	}


	public void setPedido(PedidoFornecedor pedido) {
		this.pedido.add(pedido);
	}


	@Override
	public String toString() {
		return "PedidoCompra [id=" + id + ", status=" + status + ", pedido=" + pedido + "]";
	}
	
}
