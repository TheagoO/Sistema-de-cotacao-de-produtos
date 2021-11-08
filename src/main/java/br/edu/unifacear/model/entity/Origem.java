package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Origem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ORIGEM")
	private String origem;
	
	public Origem() {
		this.id = 0;
	}
	
	public Origem(int id, String nome) {
		this.id = id;
		this.origem = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Override
	public String toString() {
		return origem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Origem other = (Origem) obj;
		return id == other.id && Objects.equals(origem, other.origem);
	}
	
	
	
}
