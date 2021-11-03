package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class PedidoCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private long codigo;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "QUANTIDADE")
	private float quantidade;
	
	@ManyToOne
	private Almoxarifado almoxarifado;

	public PedidoCompra() {
		this.id = 0;
		this.almoxarifado = new Almoxarifado();
	}

	public PedidoCompra(int id, int codigo, Almoxarifado almoxarifado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.almoxarifado = almoxarifado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
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

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(almoxarifado, codigo, id, marca, nome, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCompra other = (PedidoCompra) obj;
		return Objects.equals(almoxarifado, other.almoxarifado) && codigo == other.codigo && id == other.id
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade);
	}

}
