package br.edu.unifacear.model.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class FiscalItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NCM")
	private String ncm;
	
	@ManyToOne
	private Pais origem;
	
	public FiscalItem() {
		
	}
	
	public FiscalItem(int id, String ncm, Pais origem) {
		super();
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

	public Pais getOrigem() {
		return origem;
	}

	public void setOrigem(Pais origem) {
		this.origem = origem;
	}

	@Override
	public String toString() {
		return "FiscalItem [id=" + id + ", ncm=" + ncm + ", origem=" + origem + "]";
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
