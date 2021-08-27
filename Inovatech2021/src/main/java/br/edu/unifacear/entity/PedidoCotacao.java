package br.edu.unifacear.entity;

import java.util.Arrays;

public class PedidoCotacao {
	
	private int id;
	private int status;
	
	private CotacaoFornecedor[] fornecedor;
	private CotacaoItem[] item;
	
	public PedidoCotacao() {
		
	}
	
	public PedidoCotacao(int id, int status, CotacaoFornecedor[] fornecedor, CotacaoItem[] item) {
		super();
		this.id = id;
		this.status = status;
		this.fornecedor = fornecedor;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CotacaoFornecedor[] getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(CotacaoFornecedor[] fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CotacaoItem[] getItem() {
		return item;
	}

	public void setItem(CotacaoItem[] item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "PedidoCotacao [id=" + id + ", status=" + status + ", fornecedor=" + Arrays.toString(fornecedor)
				+ ", item=" + Arrays.toString(item) + "]";
	}
	
	
	
}
