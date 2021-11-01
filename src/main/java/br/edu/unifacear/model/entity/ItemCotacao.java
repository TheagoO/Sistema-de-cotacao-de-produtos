package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class ItemCotacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "MARCA")
	private String marca;
		
	@Column(name = "VALOR")
	private double valor;
	
	public ItemCotacao() {
		this.id = 0;
	}
	
	public ItemCotacao(int id, double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	@Override
	public String toString() {
		return "ItemCotacao [id=" + id + ", nome=" + nome + ", marca=" + marca + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marca, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCotacao other = (ItemCotacao) obj;
		return id == other.id && Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}


	

}
