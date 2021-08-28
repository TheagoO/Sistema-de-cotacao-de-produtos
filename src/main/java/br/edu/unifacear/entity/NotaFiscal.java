package br.edu.unifacear.entity;

import java.util.ArrayList;
import java.util.List;

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
		this.item = new ArrayList<>();
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
	
}
