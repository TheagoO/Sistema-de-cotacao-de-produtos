package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Cotacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private long codigo;
			
	@ManyToOne
	private CotacaoFornecedorPreco cotacaoFornecedor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cotacao")
	private List<CotacaoItem> cotacaoItem;
	
	public Cotacao() {
		this.id = 0;
		this.cotacaoFornecedor = new CotacaoFornecedorPreco();
		this.cotacaoItem = new ArrayList<CotacaoItem>();
	}

	public Cotacao(int id, long codigo, CotacaoFornecedorPreco cotacaoFornecedor, List<CotacaoItem> cotacaoItem) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cotacaoFornecedor = cotacaoFornecedor;
		this.cotacaoItem = cotacaoItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public CotacaoFornecedorPreco getCotacaoFornecedor() {
		return cotacaoFornecedor;
	}

	public void setCotacaoFornecedor(CotacaoFornecedorPreco cotacaoFornecedor) {
		this.cotacaoFornecedor = cotacaoFornecedor;
	}

	public List<CotacaoItem> getCotacaoItem() {
		return cotacaoItem;
	}

	public void setCotacaoItem(List<CotacaoItem> cotacaoItem) {
		this.cotacaoItem = cotacaoItem;
	}

	@Override
	public String toString() {
		return "Cotacao [id=" + id + ", codigo=" + codigo + ", cotacaoFornecedor=" + cotacaoFornecedor
				+ ", cotacaoItem=" + cotacaoItem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, cotacaoFornecedor, cotacaoItem, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotacao other = (Cotacao) obj;
		return codigo == other.codigo && Objects.equals(cotacaoFornecedor, other.cotacaoFornecedor)
				&& Objects.equals(cotacaoItem, other.cotacaoItem) && id == other.id;
	}

}
