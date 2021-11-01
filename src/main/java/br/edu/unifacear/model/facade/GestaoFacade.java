package br.edu.unifacear.model.facade;

import java.util.List;

import br.edu.unifacear.model.bo.AlmoxarifadoBo;
import br.edu.unifacear.model.bo.CidadeBo;
import br.edu.unifacear.model.bo.CotacaoBo;
import br.edu.unifacear.model.bo.EnderecoBo;
import br.edu.unifacear.model.bo.EstadoBo;
import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.bo.FornecedorBo;
import br.edu.unifacear.model.bo.FornecedorPedidoCotacaoBo;
import br.edu.unifacear.model.bo.GestorBo;
import br.edu.unifacear.model.bo.ItemBo;
import br.edu.unifacear.model.bo.ItemCotacaoBo;
import br.edu.unifacear.model.bo.PedidoCotacaoBo;
import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Cidade;
import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.Endereco;
import br.edu.unifacear.model.entity.Estado;
import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.FornecedorPedidoCotacao;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.entity.ItemCotacao;
import br.edu.unifacear.model.entity.PedidoCotacao;

public class GestaoFacade {

	private ItemBo itemBo;
	private FiscalItemBo fiscoItemBo;
	private AlmoxarifadoBo almoxarifadoBo;
	private GestorBo gestorBo;
	private FornecedorBo fornecedorBo;
	private CidadeBo cidadeBo;
	private EstadoBo estadoBo;
	private EnderecoBo enderecoBo;
	private PedidoCotacaoBo pedidoCotacaoBo;
	private ItemCotacaoBo itemCotacaoBo;
	private FornecedorPedidoCotacaoBo fornecedorPedidoCotacaoBo;
	private CotacaoBo cotacaoBo;

	public GestaoFacade() {
		this.fiscoItemBo = new FiscalItemBo();
		this.itemBo = new ItemBo();
		this.almoxarifadoBo = new AlmoxarifadoBo();
		this.gestorBo = new GestorBo();
		this.fornecedorBo = new FornecedorBo();
		this.cidadeBo = new CidadeBo();
		this.estadoBo = new EstadoBo();
		this.enderecoBo = new EnderecoBo();
		this.pedidoCotacaoBo = new PedidoCotacaoBo();
		this.itemCotacaoBo = new ItemCotacaoBo();
		this.fornecedorPedidoCotacaoBo = new FornecedorPedidoCotacaoBo();
		this.cotacaoBo = new CotacaoBo();
	}

	public void salvarItem(Item i) throws Exception {
		this.itemBo.salvar(i);
	}

	public List<Item> listarItens() throws Exception {
		return itemBo.listar("");
	}

	public String editarItem(Item i) throws Exception {
		return this.itemBo.alterar(i);
	}

	public String excluirItem(Item i) throws Exception {
		return this.itemBo.deletar(i);
	}

	public String salvarAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.salvar(a);
	}

	public String excluirAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.deletar(a);
	}

	public String salvarGestor(Gestor g) throws Exception {
		return this.gestorBo.salvar(g);
	}

	public String excluirGestor(Gestor g) throws Exception {
		return this.gestorBo.deletar(g);
	}

	public List<Almoxarifado> listarAlmoxarifado() throws Exception {
		return this.almoxarifadoBo.listar("");
	}

	public List<Gestor> listarGestor() throws Exception {
		return this.gestorBo.listar("");
	}

	public String editarAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.alterar(a);
	}

	public String editarGestor(Gestor g) throws Exception {
		return this.gestorBo.alterar(g);
	}

	public String salvarFornecedor(Fornecedor f) throws Exception {
		Endereco e = f.getEndereco();
		String retorno = this.enderecoBo.salvar(e);
		return retorno += this.fornecedorBo.salvar(f);
	}

	public String editarFornecedor(Fornecedor f) throws Exception {
		return this.fornecedorBo.alterar(f);
	}

	public List<Fornecedor> listarFornecedor() throws Exception {
		return this.fornecedorBo.listar("");
	}

	public String excluirFornecedor(Fornecedor f) throws Exception {
		return this.fornecedorBo.deletar(f);
	}

	public String salvarCidade(Cidade c) throws Exception {
		return this.cidadeBo.salvar(c);
	}

	public String editarCidade(Cidade c) throws Exception {
		return this.cidadeBo.alterar(c);
	}

	public String excluirCidade(Cidade c) throws Exception {
		return this.cidadeBo.deletar(c);
	}

	public List<Cidade> listarCidade() throws Exception {
		return this.cidadeBo.listar("");
	}

	public String salvarEstado(Estado e) throws Exception {
		return this.estadoBo.salvar(e);
	}

	public String editarEstado(Estado e) throws Exception {
		return this.estadoBo.alterar(e);
	}

	public String excluirEstado(Estado e) throws Exception {
		return this.estadoBo.deletar(e);
	}

	public List<Estado> listarEstado() throws Exception {
		return this.estadoBo.listar("");
	}

	public String salvarEndereco(Endereco e) throws Exception {
		return this.enderecoBo.salvar(e);
	}

	public String editarEndereco(Endereco e) throws Exception {
		return this.enderecoBo.alterar(e);
	}

	public String excluirEndereco(Endereco e) throws Exception {
		return this.enderecoBo.deletar(e);
	}

	public List<Endereco> listarEndereco() throws Exception {
		return this.enderecoBo.listar("");
	}

	public String salvarPedidoCotacao(PedidoCotacao p) throws Exception {
		return this.pedidoCotacaoBo.salvar(p);
	}

	public String editarPedidoCotacao(PedidoCotacao p) throws Exception {
		return this.pedidoCotacaoBo.alterar(p);
	}

	public String excluirPedidoCotacao(PedidoCotacao p) throws Exception {
		return this.pedidoCotacaoBo.deletar(p);
	}

	public List<PedidoCotacao> listarPedidoCotacao() throws Exception {
		return this.pedidoCotacaoBo.listar("");
	}

	public String salvarItemCotacao(ItemCotacao i) throws Exception {
		return this.itemCotacaoBo.salvar(i);
	}

	public String editarItemCotacao(ItemCotacao i) throws Exception {
		return this.itemCotacaoBo.alterar(i);
	}

	public String excluirItemCotacao(ItemCotacao i) throws Exception {
		return this.itemCotacaoBo.deletar(i);
	}

	public List<ItemCotacao> listarItemCotacao() throws Exception {
		return this.itemCotacaoBo.listar("");
	}

	public String salvarFornecedorPedidoCotacao(FornecedorPedidoCotacao i) throws Exception {
		return this.fornecedorPedidoCotacaoBo.salvar(i);
	}

	public String editarFornecedorPedidoCotacao(FornecedorPedidoCotacao i) throws Exception {
		return this.fornecedorPedidoCotacaoBo.alterar(i);
	}

	public String excluirFornecedorPedidoCotacao(FornecedorPedidoCotacao i) throws Exception {
		return this.fornecedorPedidoCotacaoBo.deletar(i);
	}

	public List<FornecedorPedidoCotacao> listarFornecedorPedidoCotacao() throws Exception {
		return this.fornecedorPedidoCotacaoBo.listar("");
	}

	public String salvarCotacao(Cotacao cotacao, List<ItemCotacao> itens) throws Exception {
		if (itens != null && cotacao == null) {

			for (ItemCotacao i : itens) {
				Cotacao c = new Cotacao();
				c.setItem(i);
				c.setPreco(i.getValor());
				c.setFornecedor(new Fornecedor(i.getId(), null, null, null, null, null));
				this.cotacaoBo.salvar(c);
			}
		} else {
			return this.cotacaoBo.salvar(cotacao);
		}

		return "";
	}

	public String editarCotacao(Cotacao c) throws Exception {
		return this.cotacaoBo.alterar(c);
	}

	public String excluirCotacao(Cotacao c) throws Exception {
		return this.cotacaoBo.deletar(c);
	}

	public List<Cotacao> listarCotacao() throws Exception {
		return this.cotacaoBo.listar("");
	}
}
