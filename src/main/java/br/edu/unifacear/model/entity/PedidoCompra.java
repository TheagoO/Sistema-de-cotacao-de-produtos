package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class PedidoCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STATUS")
	private int status;
	
	@OneToMany
	private List<PedidoItem> item;
	
	@OneToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Gestor solicitante;
	
	public PedidoCompra() {
		this.item = new ArrayList<>();
	}

	public PedidoCompra(int id, int status, List<PedidoItem> item, Fornecedor fornecedor, Gestor solicitante) {
		super();
		this.id = id;
		this.status = status;
		this.item = item;
		this.fornecedor = fornecedor;
		this.solicitante = solicitante;
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

	public List<PedidoItem> getItem() {
		return item;
	}

	public void setItem(List<PedidoItem> item) {
		this.item = item;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Gestor getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Gestor solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, item, solicitante, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCompra other = (PedidoCompra) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && Objects.equals(item, other.item)
				&& Objects.equals(solicitante, other.solicitante) && status == other.status;
	}
	
	
}
