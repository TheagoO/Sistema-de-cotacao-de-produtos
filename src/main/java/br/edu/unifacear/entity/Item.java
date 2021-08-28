package br.edu.unifacear.entity;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "VALOR")
	private double valor;
	
	@Column(name = "CODIGO")
	private long codigo;
	
	@ManyToOne
	private FiscalItem fiscal_Item;

	public Item() {
		
	}
	
	public Item(int id, String nome, String marca, double valor, long codigo, FiscalItem fiscal_Item) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.codigo = codigo;
		this.fiscal_Item = fiscal_Item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public FiscalItem getFiscal_Item() {
		return fiscal_Item;
	}

	public void setFiscal_Item(FiscalItem fiscal_Item) {
		this.fiscal_Item = fiscal_Item;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", marca=" + marca + ", valor=" + valor + ", codigo=" + codigo
				+ ", fiscal_Item=" + fiscal_Item + "]";
	}
	
	
}
