package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Item implements Serializable {
	
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fiscal_Item, id, marca, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return codigo == other.codigo && Objects.equals(fiscal_Item, other.fiscal_Item) && id == other.id
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	
}
