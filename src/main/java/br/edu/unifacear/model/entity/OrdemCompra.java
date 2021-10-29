package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class OrdemCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STATUS")
	private Status status;
	
	@OneToMany
	private List<PedidoCompra> item;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Gestor solicitante;
	
	public OrdemCompra() {
		this.id = 0;
		this.item = new ArrayList<PedidoCompra>();
		this.fornecedor = new Fornecedor();
		this.solicitante = new Gestor();
		this.status = new Status();
	}

	public OrdemCompra(int id, Status status, List<PedidoCompra> item, Fornecedor fornecedor, Gestor solicitante) {
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
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<PedidoCompra> getItem() {
		return item;
	}

	public void setItem(List<PedidoCompra> item) {
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
		OrdemCompra other = (OrdemCompra) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && Objects.equals(item, other.item)
				&& Objects.equals(solicitante, other.solicitante) && status == other.status;
	}
	
	
}
