package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdemCompra implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DATA_EMISSAO")
	private LocalDate dataEmissao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordem_id")
	private List<OrdemCompraItem> ordemCompraItem;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordem_id")
	private List<Cotacao> cotacao;

	@ManyToOne
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "fase_id")
	private Fase fase;

	@ManyToOne
	private Gestor solicitante;

	public OrdemCompra() {
		this.id = 0;
		this.dataEmissao = LocalDate.now();
		this.cotacao = new ArrayList<Cotacao>();
		this.ordemCompraItem = new ArrayList<OrdemCompraItem>();
		this.fornecedor = new Fornecedor();
		this.fase = new Fase();
		this.solicitante = new Gestor();
	}

	public OrdemCompra(int id, LocalDate dataEmissao, List<OrdemCompraItem> ordemCompraItem, List<Cotacao> cotacao,
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

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<OrdemCompraItem> getOrdemCompraItem() {
		return ordemCompraItem;
	}

	public void setOrdemCompraItem(List<OrdemCompraItem> ordemCompraItem) {
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

	public double getTotal() {
		double total = 0.0;
		for (OrdemCompraItem oci : this.ordemCompraItem) {
			total += oci.getValorTotal();
		}

		return total;
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
