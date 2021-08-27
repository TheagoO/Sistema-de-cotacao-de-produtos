package br.edu.unifacear.entity;

import java.util.Arrays;

public class PedidoFornecedor {
	
	private int id;
	private Item[] item;
	private Fornecedor fornecedor;
	
	public PedidoFornecedor() {
		
	}
	
	public PedidoFornecedor(int id, Item[] item, Fornecedor fornecedor) {
		super();
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

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "PedidoFornecedor [id=" + id + ", item=" + Arrays.toString(item) + ", fornecedor=" + fornecedor + "]";
	}
	
	
	
}
