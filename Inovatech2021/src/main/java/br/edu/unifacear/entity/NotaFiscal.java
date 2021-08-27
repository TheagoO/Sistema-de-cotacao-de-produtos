package br.edu.unifacear.entity;

import java.util.Arrays;

public class NotaFiscal {
	
	private int id;
	private int codigo;
	
	private NotaFiscalItem[] item; 
	private Fornecedor fornecedor;
	
	public NotaFiscal() {
		
	}
	
	public NotaFiscal(int id, int codigo, NotaFiscalItem[] item, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.item = item;
		this.fornecedor = fornecedor;
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

	public NotaFiscalItem[] getItem() {
		return item;
	}

	public void setItem(NotaFiscalItem[] item) {
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
		return "NotaFiscal [id=" + id + ", codigo=" + codigo + ", item=" + Arrays.toString(item) + ", fornecedor="
				+ fornecedor + "]";
	}
	
	
	
}
