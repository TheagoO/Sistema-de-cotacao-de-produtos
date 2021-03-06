package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Requisicao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fase_id")
	private Fase fase;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "requisicao_id")
	private List<RequisicaoItem> item;
		
	@ManyToOne
	private Almoxarifado solicitante;

	public Requisicao() {
		this.id = 0;
		this.fase = new Fase();
		this.item = new ArrayList<RequisicaoItem>();
		this.solicitante = new Almoxarifado();
	}

	public Requisicao(int id, Fase fase, List<RequisicaoItem> item, Almoxarifado solicitante, int codigo) {
		super();
		this.id = id;
		this.fase = fase;
		this.item = item;
		this.solicitante = solicitante;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public List<RequisicaoItem> getItem() {
		return item;
	}

	public void setItem(List<RequisicaoItem> item) {
		this.item = item;
	}

	public Almoxarifado getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Almoxarifado solicitante) {
		this.solicitante = solicitante;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Requisicao [id=" + id + ", fase=" + fase + ", codigo=" + codigo + ", item=" + item + ", solicitante="
				+ solicitante + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fase, id, item, solicitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisicao other = (Requisicao) obj;
		return codigo == other.codigo && Objects.equals(fase, other.fase) && id == other.id
				&& Objects.equals(item, other.item) && Objects.equals(solicitante, other.solicitante);
	}

}
