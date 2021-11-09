package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class FiscalItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NCM")
	private String ncm;
	
	@ManyToOne
	private Origem origem;
	
	public FiscalItem() {
		this.id = 0;
		this.origem = new Origem();
	}
	
	public FiscalItem(int id, String ncm, Origem origem) {
		this.id = id;
		this.ncm = ncm;
		this.origem = origem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	@Override
	public String toString() {
		return ncm + " - " + origem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ncm, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiscalItem other = (FiscalItem) obj;
		return id == other.id && Objects.equals(ncm, other.ncm) && Objects.equals(origem, other.origem);
	}
	
	
	
}
