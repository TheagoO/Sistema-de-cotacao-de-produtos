package br.edu.unifacear.entity;

public class CotacaoFornecedor {
	
	private int id;
	private int codigo;
	
	private Fornecedor fornecedor;

	public CotacaoFornecedor() {
		
	}
	
	public CotacaoFornecedor(int id, int codigo, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.codigo = codigo;
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "CotacaoFornecedor [id=" + id + ", codigo=" + codigo + ", fornecedor=" + fornecedor + "]";
	}
	
	
}
