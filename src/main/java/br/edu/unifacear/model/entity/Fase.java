package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Fase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "STATUS")
	private int status;
	
	@OneToMany
	@JoinColumn(name = "fase_id")
	private List<Requisicao> requisicao;
	
	@OneToMany
	@JoinColumn(name = "fase_id")
	private List<OrdemCompra> ordem;
	
	public Fase() {
		this.id = 0;
		this.status = 0;
		this.requisicao = new ArrayList<Requisicao>();
		this.ordem = new ArrayList<OrdemCompra>();
	}

	public Fase(int id, int status) {
		this.id = id;
		this.status = status;
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

	public List<Requisicao> getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(List<Requisicao> requisicao) {
		this.requisicao = requisicao;
	}

	public List<OrdemCompra> getOrdem() {
		return ordem;
	}

	public void setOrdem(List<OrdemCompra> ordem) {
		this.ordem = ordem;
	}

	@Override
	public String toString() {
		switch (this.status) {
		case 1:
			return "Pendente";
		case 2:
			return "Aguardando aprovação";
		case 3:
			return "Aprovado";
		case 4:
			return "Finalizado";
		case 5:
			return "Aguardando cotação";
		default:
			return "Negado";
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fase other = (Fase) obj;
		return id == other.id && Objects.equals(status, other.status);
	}

	
}
