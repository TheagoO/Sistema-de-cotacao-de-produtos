package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Fase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "STATUS")
	private int status;

	public Fase() {
		this.id = 0;
		this.status = 0;
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
