package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Contato implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CONTATO")
	private String contato;
	
	@ManyToOne
	private TipoContato tipo;

	public Contato() {
		this.id = 0;
		this.tipo = new TipoContato();
	}
	
	public Contato(int id, String contato, TipoContato tipo) {
		this.id = id;
		this.contato = contato;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return this.contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, id, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(contato, other.contato) && id == other.id && Objects.equals(tipo, other.tipo);
	}
	
	
	
}
