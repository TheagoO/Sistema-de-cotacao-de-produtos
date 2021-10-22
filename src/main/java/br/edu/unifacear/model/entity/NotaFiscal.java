package br.edu.unifacear.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class NotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@OneToMany
	private List<NotaFiscalItem> item = new ArrayList<>();
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	public NotaFiscal() {
		this.item = new ArrayList<>();
	}
	

	public NotaFiscal(int id, int codigo, List<NotaFiscalItem> item, Fornecedor fornecedor) {
		super();
		this.item = item;
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

	

	public NotaFiscalItem getItem(int i) {
		return item.get(i);
	}


	public void setItem(NotaFiscalItem item) {
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
		return "NotaFiscal [id=" + id + ", codigo=" + codigo + ", item=" + item + ", fornecedor=" + fornecedor + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo, fornecedor, id, item);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		return codigo == other.codigo && Objects.equals(fornecedor, other.fornecedor) && id == other.id
				&& Objects.equals(item, other.item);
	}
	
	
	
}
