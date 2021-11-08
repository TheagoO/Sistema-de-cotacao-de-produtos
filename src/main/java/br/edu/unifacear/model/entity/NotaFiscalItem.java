package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class NotaFiscalItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "QTD")
	private float quantidade;
	
	@Column(name = "VALOR_UNI")
	private double valorUnitario;
	
	@Column(name = "TOTAL")
	private double total;
	
	@ManyToOne
	private Produto item;
	

	public NotaFiscalItem() {
		this.id = 0;
		this.item = new Produto();
	}
	
	public NotaFiscalItem(int id, int codigo, float quantidade, double valorUnitario, double total, Produto item) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.total = total;
		this.item = item;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Produto getItem() {
		return item;
	}

	public void setItem(Produto item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "NotaFiscalItem [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", total=" + total + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id, item, quantidade, total, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscalItem other = (NotaFiscalItem) obj;
		return codigo == other.codigo && id == other.id && Objects.equals(item, other.item)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total)
				&& Double.doubleToLongBits(valorUnitario) == Double.doubleToLongBits(other.valorUnitario);
	}

	
}
