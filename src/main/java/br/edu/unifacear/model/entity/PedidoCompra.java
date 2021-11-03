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
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Almoxarifado almoxarifado;

	public PedidoCompra() {
		this.id = 0;
		this.item = new Item();
		this.almoxarifado = new Almoxarifado();
	}

	public PedidoCompra(int id, int codigo, Item item, Almoxarifado almoxarifado) {
		super();
		this.id = id;
		this.codigo = codigo;
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
		return "PedidoItem [id=" + id + ", codigo=" + codigo + " item=" + item
				+ ", almoxarifado=" + almoxarifado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(almoxarifado, codigo, id, item);
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
				&& Objects.equals(item, other.item);
	}
	
	
	
	
	
}
