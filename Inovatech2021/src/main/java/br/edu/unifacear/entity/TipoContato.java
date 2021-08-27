package br.edu.unifacear.entity;

public class TipoContato {
	
	private int id;
	private String nome;
	
	public TipoContato() {
		
	}
	
	public TipoContato(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoContato [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
