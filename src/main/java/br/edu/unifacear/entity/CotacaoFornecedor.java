package br.edu.unifacear.entity;

import javax.persistence.*;

@Entity
public class CotacaoFornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@ManyToOne
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
