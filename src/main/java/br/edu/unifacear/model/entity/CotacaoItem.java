package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CotacaoItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "QUANTIDADE")
	private float quantidade;
	
	@Column(name = "CODIGO")
	private long codigo;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "cotacao_id")
	private Cotacao cotacao;
	
	@OneToMany
	@JoinColumn(name = "cotacaoItem_id")
	private List<CotacaoFornecedorPreco> cotacaoForncedor;
	
	public CotacaoItem() {
		this.id = 0;
		this.produto = new Produto();
		this.cotacao = new Cotacao();
	}


	public CotacaoItem(int id, float quantidade, long codigo, Produto produto, Cotacao cotacao,
			List<CotacaoFornecedorPreco> cotacaoForncedor) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.produto = produto;
		this.cotacao = cotacao;
		this.cotacaoForncedor = cotacaoForncedor;
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

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public List<CotacaoFornecedorPreco> getCotacaoForncedor() {
		return cotacaoForncedor;
	}


	public void setCotacaoForncedor(List<CotacaoFornecedorPreco> cotacaoForncedor) {
		this.cotacaoForncedor = cotacaoForncedor;
	}


	@Override
	public String toString() {
		return "CotacaoItem [id=" + id + ", quantidade=" + quantidade + ", codigo=" + codigo + ", produto=" + produto
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoItem other = (CotacaoItem) obj;
		return codigo == other.codigo && id == other.id && Objects.equals(produto, other.produto)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade);
	}
	
}
