package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class CotacaoFornecedorPreco implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private CotacaoItem cotacaoItem;
	
	@Column(name = "PRECO")
	private double preco;
	
	
	public CotacaoFornecedorPreco() {
		this.id = 0;
		this.cotacaoItem = new CotacaoItem();
		this.fornecedor = new Fornecedor();
	}

	public CotacaoFornecedorPreco(int id, Fornecedor fornecedor, CotacaoItem cotacaoItem, double preco) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.cotacaoItem = cotacaoItem;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CotacaoItem getCotacaoItem() {
		return cotacaoItem;
	}

	public void setCotacaoItem(CotacaoItem cotacaoItem) {
		this.cotacaoItem = cotacaoItem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "CotacaoFornecedorPreco [id=" + id + ", fornecedor=" + fornecedor + ", cotacaoItem=" + cotacaoItem
				+ ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaoItem, fornecedor, id, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoFornecedorPreco other = (CotacaoFornecedorPreco) obj;
		return Objects.equals(cotacaoItem, other.cotacaoItem) && Objects.equals(fornecedor, other.fornecedor)
				&& id == other.id && Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	
}
