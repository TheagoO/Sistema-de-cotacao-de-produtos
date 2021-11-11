package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class RequisicaoItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Column(name = "QUANTIDADE")
	private float quantidade;

	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "requisicao_id")
	private Requisicao requisicao;
	
	public RequisicaoItem() {
		this.id = 0;
		this.produto = new Produto();
		this.requisicao = new Requisicao();
	}


	public RequisicaoItem(int id, float quantidade, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Requisicao getRequisicao() {
		return requisicao;
	}


	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}


	@Override
	public String toString() {
		return "RequisicaoItem [id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, produto, quantidade);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequisicaoItem other = (RequisicaoItem) obj;
		return id == other.id && Objects.equals(produto, other.produto)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade);
	}

}
