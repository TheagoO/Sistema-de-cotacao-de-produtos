package br.edu.unifacear.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemCompraItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "QUANTIDADE")
	private float quantidade;
	
	@Column(name = "CODIGO")
	private long codigo;
	
	@Column(name = "VALOR_UNITARIO")
	private double valorUnitario;
	
	@Column(name = "TOTAL")
	private double valorTotal;
	
	@ManyToOne
	private Produto produto;
	
	
	
	public OrdemCompraItem() {
		this.id = 0;
		this.produto = new Produto();
	}

	public OrdemCompraItem(int id, float quantidade, long codigo, double valorUnitario, double valorTotal,
			Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
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

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "OrdemCompraItem [id=" + id + ", quantidade=" + quantidade + ", codigo=" + codigo + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + ", produto=" + produto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id, produto, quantidade, valorTotal, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemCompraItem other = (OrdemCompraItem) obj;
		return codigo == other.codigo && id == other.id && Objects.equals(produto, other.produto)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal)
				&& Double.doubleToLongBits(valorUnitario) == Double.doubleToLongBits(other.valorUnitario);
	}
	
}
