package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Cotacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATA_EMISSAO")
	private Date dataEmissao;
	
	@Column(name = "PRECO")
	private double preco;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private ItemCotacao item;
	
	public Cotacao() {
		this.id = 0;
		this.dataEmissao = new Date();
		this.fornecedor = new Fornecedor();
		this.item = new ItemCotacao();
	}

	public Cotacao(int id, Date dataEmissao, Fornecedor fornecedor, ItemCotacao item, double preco) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.fornecedor = fornecedor;
		this.item = item;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ItemCotacao getItem() {
		return item;
	}

	public void setItem(ItemCotacao item) {
		this.item = item;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Cotacao [id=" + id + ", dataEmissao=" + dataEmissao + ", preco=" + preco + ", fornecedor=" + fornecedor
				+ ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEmissao, fornecedor, id, item, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotacao other = (Cotacao) obj;
		return Objects.equals(dataEmissao, other.dataEmissao) && Objects.equals(fornecedor, other.fornecedor)
				&& id == other.id && Objects.equals(item, other.item)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	
}
