package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class CotacaoFornecedor implements Serializable {
	
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fornecedor, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoFornecedor other = (CotacaoFornecedor) obj;
		return codigo == other.codigo && Objects.equals(fornecedor, other.fornecedor) && id == other.id;
	}
	
	
}
