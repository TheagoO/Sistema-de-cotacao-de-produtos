package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Pais implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "PAIS")
	private String pais;
	
	public Pais() {
		this.id = 0;
	}
	
	public Pais(int id, String nome) {
		super();
		this.id = id;
		this.pais = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return id +"-"+pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return id == other.id && Objects.equals(pais, other.pais);
	}
	
	
	
}
