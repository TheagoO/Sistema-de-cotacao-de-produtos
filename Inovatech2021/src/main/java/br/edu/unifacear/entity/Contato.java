package br.edu.unifacear.entity;

public class Contato {
	
	private int id;
	private String contato;
	
	private TipoContato tipo;

	public Contato() {
		
	}
	
	public Contato(int id, String contato, TipoContato tipo) {
		super();
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
		return "Contato [id=" + id + ", contato=" + contato + ", tipo=" + tipo + "]";
	}
	
	
}
