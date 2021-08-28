package br.edu.unifacear.entity;

import javax.persistence.*;

@Entity
public class FiscalItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NCM")
	private String ncm;
	
	@Column(name = "ORIGEM")
	private String origem;
	
	public FiscalItem() {
		
	}
	
	public FiscalItem(int id, String ncm, String origem) {
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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Override
	public String toString() {
		return "FiscalItem [id=" + id + ", ncm=" + ncm + ", origem=" + origem + "]";
	}
	
	
	
}
