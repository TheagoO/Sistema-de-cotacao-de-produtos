package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Produto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "CODIGO")
	private long codigo;
		
	@ManyToOne
	private FiscalItem fiscalItem;

	public Produto() {
		this.id = 0;
		this.fiscalItem = new FiscalItem();
	}
	
	public Produto(int id, String nome, String marca , double valor, long codigo, FiscalItem fiscal_Item ) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.codigo = codigo;
		this.fiscalItem = fiscal_Item;
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

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public FiscalItem getFiscalItem() {
		return fiscalItem;
	}

	public void setFiscalItem(FiscalItem fiscalItem) {
		this.fiscalItem = fiscalItem;
	}
	
	@Override
	public String toString() {
		return "Item [nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fiscalItem, id, marca, nome);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codigo == other.codigo && Objects.equals(fiscalItem, other.fiscalItem) && id == other.id
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome);
	}

	
	
	
}
