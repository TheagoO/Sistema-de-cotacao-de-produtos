package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class NotaFiscal implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<NotaFiscalItem> item;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@Column(name = "DATA_EMISSAO")
	private LocalDateTime dataEmissao;
	
	public NotaFiscal() {
		this.id = 0;
		this.item = new ArrayList<NotaFiscalItem>();
		this.fornecedor = new Fornecedor();
		this.dataEmissao = LocalDateTime.now();
	}

	public NotaFiscal(int id, int codigo, List<NotaFiscalItem> item, Fornecedor fornecedor, LocalDateTime dataEmissao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.item = item;
		this.fornecedor = fornecedor;
		this.dataEmissao = dataEmissao;
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

	public List<NotaFiscalItem> getItem() {
		return item;
	}

	public void setItem(List<NotaFiscalItem> item) {
		this.item = item;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", codigo=" + codigo + ", item=" + item + ", fornecedor=" + fornecedor
				+ ", dataEmissao=" + dataEmissao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataEmissao, fornecedor, id, item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		return codigo == other.codigo && Objects.equals(dataEmissao, other.dataEmissao)
				&& Objects.equals(fornecedor, other.fornecedor) && id == other.id && Objects.equals(item, other.item);
	}

	
}
