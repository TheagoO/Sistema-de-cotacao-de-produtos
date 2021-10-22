package br.edu.unifacear.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class PedidoFornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Item> item = new ArrayList<>();
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	public PedidoFornecedor() {
		this.item = new ArrayList<>();
	}
	
	public PedidoFornecedor(int id, List<Item> item, Fornecedor fornecedor) {
		super();
		this.item = new ArrayList<>();
		this.id = id;
		this.item = item;
		this.fornecedor = fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem(int i) {
		return item.get(i);
	}

	public void setItem(Item item) {
		this.item.add(item);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "PedidoFornecedor [id=" + id + ", item=" + item + ", fornecedor=" + fornecedor + "]";
	}

	
	
	
	
}
