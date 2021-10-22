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
	
	@Column(name = "STATUS")
	private int status;
	
	@OneToMany
	private List<CotacaoFornecedor> fornecedor;
	
	@OneToMany
	private List<CotacaoItem> item;
	
	@ManyToOne
	private Gestor solicitante;	
	
	public PedidoCotacao() {
		this.fornecedor = new ArrayList<>();
		this.item = new ArrayList<>();
	}

	
	public PedidoCotacao(int id, int status, List<CotacaoFornecedor> fornecedor, List<CotacaoItem> item,
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<CotacaoFornecedor> getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(List<CotacaoFornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}


	public List<CotacaoItem> getItem() {
		return item;
	}


	public void setItem(List<CotacaoItem> item) {
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
