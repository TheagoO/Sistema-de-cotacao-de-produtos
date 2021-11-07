package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdemCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATA_EMISSAO")
	private LocalDateTime dataEmissao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ordem")
	private List<RequisicaoItem> ordemCompraItem;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cotacao")
	private List<Cotacao> cotacao;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Fase fase;
	
	@ManyToOne
	private Gestor solicitante;

	public OrdemCompra() {
		this.id = 0;
		this.cotacao = new ArrayList<Cotacao>();
		this.ordemCompraItem = new ArrayList<RequisicaoItem>();
		this.fornecedor = new Fornecedor();
		this.fase = new Fase();
		this.solicitante = new Gestor();
	}

	public OrdemCompra(int id, LocalDateTime dataEmissao, List<RequisicaoItem> ordemCompraItem, List<Cotacao> cotacao,
			Fornecedor fornecedor, Fase fase, Gestor solicitante) {
		super();
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.ordemCompraItem = ordemCompraItem;
		this.cotacao = cotacao;
		this.fornecedor = fornecedor;
		this.fase = fase;
		this.solicitante = solicitante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<RequisicaoItem> getOrdemCompraItem() {
		return ordemCompraItem;
	}

	public void setOrdemCompraItem(List<RequisicaoItem> ordemCompraItem) {
		this.ordemCompraItem = ordemCompraItem;
	}

	public List<Cotacao> getCotacao() {
		return cotacao;
	}

	public void setCotacao(List<Cotacao> cotacao) {
		this.cotacao = cotacao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Gestor getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Gestor solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public String toString() {
		return "OrdemCompra [id=" + id + ", dataEmissao=" + dataEmissao + ", ordemCompraItem=" + ordemCompraItem
				+ ", cotacao=" + cotacao + ", fornecedor=" + fornecedor + ", fase=" + fase + ", solicitante="
				+ solicitante + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacao, dataEmissao, fase, fornecedor, id, ordemCompraItem, solicitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemCompra other = (OrdemCompra) obj;
		return Objects.equals(cotacao, other.cotacao) && Objects.equals(dataEmissao, other.dataEmissao)
				&& Objects.equals(fase, other.fase) && Objects.equals(fornecedor, other.fornecedor) && id == other.id
				&& Objects.equals(ordemCompraItem, other.ordemCompraItem)
				&& Objects.equals(solicitante, other.solicitante);
	}

	
	
}
