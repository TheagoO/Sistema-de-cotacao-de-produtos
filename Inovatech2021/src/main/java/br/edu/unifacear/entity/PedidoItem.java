package br.edu.unifacear.entity;

public class PedidoItem {
	
	private int id;
	private int codigo;
	private float quantidade;
	
	private Item item;
	private Almoxarifado almoxarifado;

	public PedidoItem() {
		
	}

	public PedidoItem(int id, int codigo, float quantidade, Item item, Almoxarifado almoxarifado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.item = item;
		this.almoxarifado = almoxarifado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	@Override
	public String toString() {
		return "PedidoItem [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", item=" + item
				+ ", almoxarifado=" + almoxarifado + "]";
	}
	
	
	
	
	
}
