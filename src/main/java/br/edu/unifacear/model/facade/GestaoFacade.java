package br.edu.unifacear.model.facade;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.bo.*;
import br.edu.unifacear.model.entity.*;

public class GestaoFacade {

	private ItemBo itemBo;
	private FiscalItemBo fiscalItemBo;
	private AlmoxarifadoBo almoxarifadoBo;
	private GestorBo gestorBo;
	private FornecedorBo fornecedorBo;
	private CidadeBo cidadeBo;
	private EstadoBo estadoBo;
	private EnderecoBo enderecoBo;
	private PedidoCotacaoBo pedidoCotacaoBo;
	private ItemCotacaoBo itemCotacaoBo;
	private CotacaoFornecedorBo cotacaoFornecedorBo;
	private CotacaoBo cotacaoBo;
	private OrdemCompraBo ordemCompraBo;
	private OrdemCompraItemBo pedidoCompraItemBo;
	private NotaFiscalBo notaFiscalBo;
	private NotafFiscalItemBo notaFiscalItemBo;

	public GestaoFacade() {
		this.fiscalItemBo = new FiscalItemBo();
		this.itemBo = new ItemBo();
		this.almoxarifadoBo = new AlmoxarifadoBo();
		this.gestorBo = new GestorBo();
		this.fornecedorBo = new FornecedorBo();
		this.cidadeBo = new CidadeBo();
		this.estadoBo = new EstadoBo();
		this.enderecoBo = new EnderecoBo();
		this.pedidoCotacaoBo = new PedidoCotacaoBo();
		this.itemCotacaoBo = new ItemCotacaoBo();
		this.cotacaoFornecedorBo = new CotacaoFornecedorBo();
		this.cotacaoBo = new CotacaoBo();
		this.ordemCompraBo =new OrdemCompraBo();
		this.pedidoCompraItemBo = new OrdemCompraItemBo();
		this.notaFiscalBo = new NotaFiscalBo();
		this.notaFiscalItemBo = new NotafFiscalItemBo();
	}

	public void salvarItem(Produto i) throws Exception {
		this.itemBo.salvar(i);
	}

	public List<Produto> listarItens() throws Exception {
		return itemBo.listar("");
	}

	public String editarItem(Produto i) throws Exception {
		return this.itemBo.alterar(i);
	}

	public String excluirItem(Produto i) throws Exception {
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

	public List<Almoxarifado> listarAlmoxarifado(String s) throws Exception {
		return this.almoxarifadoBo.listar(s);
	}

	public List<Gestor> listarGestor(String s) throws Exception {
		return this.gestorBo.listar(s);
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

	public String salvarCotacaoFornecedor(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorBo.salvar(i);
	}

	public String editarCotacaoFornecedor(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorBo.alterar(i);
	}

	public String excluirCotacaoFornecedor(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorBo.deletar(i);
	}

	public List<CotacaoFornecedorPreco> listarCotacaoFornecedor(int id) throws Exception {				
		return this.cotacaoFornecedorBo.listar("");
	}

	public String salvarCotacao(Cotacao cotacao) throws Exception {
		
		return null;
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


	public String salvarOrdemCompra(Requisicao e) throws Exception {
		return this.ordemCompraBo.salvar(e);
	}
	
	public String editarOrdemCompra(Requisicao e) throws Exception {
		return this.ordemCompraBo.alterar(e);
	}
	
	public String excluirOrdemCompra(Requisicao e) throws Exception {
		return this.ordemCompraBo.deletar(e);
	}
	
	public List<Requisicao> listarOrdemCompra(String e) throws Exception {		
		return this.ordemCompraBo.listar("");
	}
	
	public List<RequisicaoItem> listarOrdemCompraItem(int id) throws Exception {		
		
		
		return null;
	}
	
	
	public String salvarPedidoCompra(RequisicaoItem e) throws Exception {
		return this.pedidoCompraItemBo.salvar(e);
	}
	
	public String editarPedidoCompra(RequisicaoItem e) throws Exception {
		return this.pedidoCompraItemBo.alterar(e);
	}
	
	public String excluirPedidoCompra(RequisicaoItem e) throws Exception {
		return this.pedidoCompraItemBo.deletar(e);
	}
	
	public List<RequisicaoItem> listarPedidoCompra(String e) throws Exception {
		return this.pedidoCompraItemBo.listar("");
	}
	
	public String salvarNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.salvar(e);
	}
	
	public String editarNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.alterar(e);
	}
	
	public String excluirNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.deletar(e);
	}
	
	public List<NotaFiscal> listarNotaFiscal(String e) throws Exception {
		return this.notaFiscalBo.listar("");
	}
	
	public String salvarNotaFiscalItem(NotaFiscalItem e) throws Exception {
		return this.notaFiscalItemBo.salvar(e);
	}
	
}