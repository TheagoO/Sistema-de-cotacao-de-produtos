package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class PedidoCotacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "STATUS")
	private Status status;
	
	@OneToMany
	private List<FornecedorPedidoCotacao> fornecedor;
	
	@OneToMany
	private List<ItemCotacao> item;
	
	@ManyToOne
	private Gestor solicitante;	
	
	public PedidoCotacao() {
		this.id = 0;
		this.fornecedor = new ArrayList<FornecedorPedidoCotacao>();
		this.item = new ArrayList<ItemCotacao>();
		this.solicitante = new Gestor();
		this.status = new Status();
	}

	
	public PedidoCotacao(int id, Status status, List<FornecedorPedidoCotacao> fornecedor, List<ItemCotacao> item,
			Gestor solicitante) {
		super();
		this.id = id;
		this.status = status;
		this.fornecedor = fornecedor;
		this.item = item;
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

	public List<FornecedorPedidoCotacao> getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(List<FornecedorPedidoCotacao> fornecedor) {
		this.fornecedor = fornecedor;
	}


	public List<ItemCotacao> getItem() {
		return item;
	}


	public void setItem(List<ItemCotacao> item) {
		this.item = item;
	}


	public Gestor getSolicitante() {
		return solicitante;
	}


	public void setSolicitante(Gestor solicitante) {
		this.solicitante = solicitante;
	}


	@Override
	public String toString() {
		return "PedidoCotacao [id=" + id + ", status=" + status + ", fornecedor=" + fornecedor + ", item=" + item
				+ ", solicitante=" + solicitante + "]";
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
		PedidoCotacao other = (PedidoCotacao) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && Objects.equals(item, other.item)
				&& Objects.equals(solicitante, other.solicitante) && status == other.status;
	}
	
	
}
