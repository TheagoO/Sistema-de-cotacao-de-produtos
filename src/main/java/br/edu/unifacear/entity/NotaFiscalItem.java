package br.edu.unifacear.entity;

import javax.persistence.*;

@Entity
public class NotaFiscalItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "QTD")
	private float quantidade;
	
	@Column(name = "VALOR_UNI")
	private double valor_Unitario;
	
	@Column(name = "TOTAL")
	private double valor_total;
	
	@ManyToOne
	private Item item;

	public NotaFiscalItem() {
		
	}
	
	public NotaFiscalItem(int id, int codigo, float quantidade, double valor_Unitario, double valor_total, Item item) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor_Unitario = valor_Unitario;
		this.valor_total = valor_total;
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

	public double getValor_Unitario() {
		return valor_Unitario;
	}

	public void setValor_Unitario(double valor_Unitario) {
		this.valor_Unitario = valor_Unitario;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "NotaFiscalItem [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", valor_Unitario="
				+ valor_Unitario + ", valor_total=" + valor_total + ", item=" + item + "]";
	}
	
	
	
}
