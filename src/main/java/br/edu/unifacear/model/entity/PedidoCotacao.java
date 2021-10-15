package br.edu.unifacear.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class PedidoCotacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STATUS")
	private int status;
	
	@OneToMany
	private List<CotacaoFornecedor> fornecedor = new ArrayList<>();
	
	@OneToMany
	private List<CotacaoItem> item = new ArrayList<>();
	
	public PedidoCotacao() {
		this.fornecedor = new ArrayList<>();
		this.item = new ArrayList<>();
	}

	public PedidoCotacao(int id, int status, List<CotacaoFornecedor> fornecedor, List<CotacaoItem> item) {
		super();
		this.fornecedor = new ArrayList<>();
		this.item = new ArrayList<>();
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

	public CotacaoFornecedor getFornecedor(int i) {
		return fornecedor.get(i);
	}

	public void setFornecedor(CotacaoFornecedor fornecedor) {
		this.fornecedor.add(fornecedor);
	}

	public CotacaoItem getItem(int i) {
		return item.get(i);
	}

	public void setItem(CotacaoItem item) {
		this.item.add(item);
	}

	@Override
	public String toString() {
		return "PedidoCotacao [id=" + id + ", status=" + status + ", fornecedor=" + fornecedor + ", item=" + item + "]";
	}

	
}
