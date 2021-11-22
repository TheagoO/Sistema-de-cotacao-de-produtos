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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cotacao_id")
	private List<CotacaoItem> cotacaoItem;

	@ManyToOne
	@JoinColumn(name = "ordem_id")
	private OrdemCompra ordemCompra;
	
	public Cotacao() {
		this.id = 0;
		this.ordemCompra = new OrdemCompra();
		this.cotacaoItem = new ArrayList<CotacaoItem>();
	}

	public Cotacao(int id, long codigo, List<CotacaoItem> cotacaoItem, OrdemCompra ordemCompra) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cotacaoItem = cotacaoItem;
		this.ordemCompra = ordemCompra;
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

	public List<CotacaoItem> getCotacaoItem() {
		return cotacaoItem;
	}

	public void setCotacaoItem(List<CotacaoItem> cotacaoItem) {
		this.cotacaoItem = cotacaoItem;
	}

	public OrdemCompra getOrdemCompra() {
		return ordemCompra;
	}

	public void setOrdemCompra(OrdemCompra ordemCompra) {
		this.ordemCompra = ordemCompra;
	}

	@Override
	public String toString() {
		return "Cotacao [id=" + id + ", codigo=" + codigo + ", cotacaoItem=" + cotacaoItem + ", ordemCompra="
				+ ordemCompra + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, cotacaoItem, id, ordemCompra);
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
		return codigo == other.codigo && Objects.equals(cotacaoItem, other.cotacaoItem) && id == other.id
				&& Objects.equals(ordemCompra, other.ordemCompra);
	}


}
