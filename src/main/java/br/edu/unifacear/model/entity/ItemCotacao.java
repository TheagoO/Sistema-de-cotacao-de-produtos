package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class ItemCotacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DISPONIBILIDADE")
	private String disponibilidade;
	
	@Column(name = "QUANTIDADE")
	private float quantidade;
	
	@ManyToOne
	private Item item;

	public ItemCotacao() {
		this.id = 0;
		this.item = new Item();
	}
	
	public ItemCotacao(int id, String disponibilidade, float quantidade, Item item) {
		super();
		this.id = id;
		this.disponibilidade = disponibilidade;
		this.quantidade = quantidade;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
		
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemCotacao [id=" + id + ", disponibilidade=" + disponibilidade + ", quantidade=" + quantidade
				+ ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponibilidade, id, item, quantidade);
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
		return Objects.equals(disponibilidade, other.disponibilidade) && id == other.id
				&& Objects.equals(item, other.item)
				&& Float.floatToIntBits(quantidade) == Float.floatToIntBits(other.quantidade);
	}


}
