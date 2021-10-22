package br.edu.unifacear.model.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class CotacaoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "QUANTIDADE")
	private float quantidade;
	
	@Column(name = "DISPONIBILIDADE")
	private String disponibilidade;
	
	@Column(name = "VALOR_UNI")
	private double valor_Unitario;
	
	@Column(name = "TOTAL")
	private double valor_Total;
	
	@ManyToOne
	private Item item;

	public CotacaoItem() {
		
	}
	
	public CotacaoItem(int id, float quantidade, String disponibilidade, double valor_Unitario, double valor_Total,
			Item item) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.disponibilidade = disponibilidade;
		this.valor_Unitario = valor_Unitario;
		this.valor_Total = valor_Total;
		this.item = item;
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

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public double getValor_Unitario() {
		return valor_Unitario;
	}

	public void setValor_Unitario(double valor_Unitario) {
		this.valor_Unitario = valor_Unitario;
	}

	public double getValor_Total() {
		return valor_Total;
	}

	public void setValor_Total(double valor_Total) {
		this.valor_Total = valor_Total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "CotacaoItem [id=" + id + ", quantidade=" + quantidade + ", disponibilidade=" + disponibilidade
				+ ", valor_Unitario=" + valor_Unitario + ", valor_Total=" + valor_Total + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponibilidade, id, item, quantidade, valor_Total, valor_Unitario);
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
		return Objects.equals(disponibilidade, other.disponibilidade) && id == other.id
				&& Objects.equals(item, other.item)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade)
				&& Double.doubleToLongBits(valor_Total) == Double.doubleToLongBits(other.valor_Total)
				&& Double.doubleToLongBits(valor_Unitario) == Double.doubleToLongBits(other.valor_Unitario);
	}
	
	
}
