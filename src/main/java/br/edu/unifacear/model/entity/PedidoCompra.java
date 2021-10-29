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
	private int codigo;
	
	@Column(name = "QTD")
	private float quantidade;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Almoxarifado almoxarifado;

	public PedidoCompra() {
		this.id = 0;
		this.item = new Item();
		this.almoxarifado = new Almoxarifado();
	}

	public PedidoCompra(int id, int codigo, float quantidade, Item item, Almoxarifado almoxarifado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.item = item;
		this.almoxarifado = almoxarifado;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	@Override
	public String toString() {
		return "PedidoItem [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", item=" + item
				+ ", almoxarifado=" + almoxarifado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(almoxarifado, codigo, id, item, quantidade);
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
				&& Objects.equals(item, other.item)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade);
	}
	
	
	
	
	
}
