package br.edu.unifacear.entity;

public class CotacaoItem {
	
	private int id;
	private float quantidade;
	private String disponibilidade;
	private double valor_Unitario;
	private double valor_Total;
	
	private Item item;

	public CotacaoItem() {
		
	}
	
	public CotacaoItem(int id, float quantidade, String disponibilidade, double valor_Unitario, double valor_Total,
			Item item) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.disponibilidade = disponibilidade;
		this.valor_Unitario = valor_Unitario;
		this.valor_Total = valor_Total;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public double getValor_Unitario() {
		return valor_Unitario;
	}

	public void setValor_Unitario(double valor_Unitario) {
		this.valor_Unitario = valor_Unitario;
	}

	public double getValor_Total() {
		return valor_Total;
	}

	public void setValor_Total(double valor_Total) {
		this.valor_Total = valor_Total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "CotacaoItem [id=" + id + ", quantidade=" + quantidade + ", disponibilidade=" + disponibilidade
				+ ", valor_Unitario=" + valor_Unitario + ", valor_Total=" + valor_Total + ", item=" + item + "]";
	}
	
	
}
