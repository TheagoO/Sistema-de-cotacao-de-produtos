package br.edu.unifacear.model.facade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import br.edu.unifacear.model.bo.*;
import br.edu.unifacear.model.entity.*;

public class GestaoFacade {

	private ProdutoBo produtoBo;
	private FiscalItemBo fiscalItemBo;
	private AlmoxarifadoBo almoxarifadoBo;
	private GestorBo gestorBo;
	private FornecedorBo fornecedorBo;
	private CidadeBo cidadeBo;
	private EstadoBo estadoBo;
	private EnderecoBo enderecoBo;
	private CotacaoFornecedorPrecoBo cotacaoFornecedorPrecoBo;
	private CotacaoBo cotacaoBo;
	private OrdemCompraBo ordemCompraBo;
	private OrdemCompraItemBo ordemCompraItemBo;
	private NotaFiscalBo notaFiscalBo;
	private NotafFiscalItemBo notaFiscalItemBo;
	private CotacaoItemBo cotacaoItemBo;
	private FaseBo faseBo;
	private OrigemBo origemBo;
	private RequisicaoBo requisicaoBo;
	private RequisicaoItemBo requisicaoItemBo;

	public GestaoFacade() {
		this.fiscalItemBo = new FiscalItemBo();
		this.produtoBo = new ProdutoBo();
		this.almoxarifadoBo = new AlmoxarifadoBo();
		this.gestorBo = new GestorBo();
		this.fornecedorBo = new FornecedorBo();
		this.cidadeBo = new CidadeBo();
		this.estadoBo = new EstadoBo();
		this.enderecoBo = new EnderecoBo();
		this.cotacaoFornecedorPrecoBo = new CotacaoFornecedorPrecoBo();
		this.cotacaoBo = new CotacaoBo();
		this.ordemCompraBo = new OrdemCompraBo();
		this.ordemCompraItemBo = new OrdemCompraItemBo();
		this.notaFiscalBo = new NotaFiscalBo();
		this.notaFiscalItemBo = new NotafFiscalItemBo();
		this.cotacaoItemBo = new CotacaoItemBo();
		this.faseBo = new FaseBo();
		this.origemBo = new OrigemBo();
		this.requisicaoBo = new RequisicaoBo();
		this.requisicaoItemBo = new RequisicaoItemBo();
	}

	// PRODUTO
	public void salvarProduto(Produto i) throws Exception {
		this.produtoBo.salvar(i);
	}

	public List<Produto> listarProduto(String s) throws Exception {
		return produtoBo.listar(s);
	}

	public String editarProduto(Produto i) throws Exception {
		return this.produtoBo.alterar(i);
	}

	public String excluirProduto(Produto i) throws Exception {
		return this.produtoBo.deletar(i);
	}

	// ALMOXARIFADO
	public String salvarAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.salvar(a);
	}

	public String excluirAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.deletar(a);
	}

	public String editarAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.alterar(a);
	}

	public List<Almoxarifado> listarAlmoxarifado(String s) throws Exception {
		return this.almoxarifadoBo.listar(s);
	}

	// GESTOR
	public String salvarGestor(Gestor g) throws Exception {
		return this.gestorBo.salvar(g);
	}

	public String excluirGestor(Gestor g) throws Exception {
		return this.gestorBo.deletar(g);
	}

	public List<Gestor> listarGestor(String s) throws Exception {
		return this.gestorBo.listar(s);
	}

	public String editarGestor(Gestor g) throws Exception {
		return this.gestorBo.alterar(g);
	}

	// FORNECEDOR
	public String salvarFornecedor(Fornecedor f, Endereco e) throws Exception {
		try {
			this.enderecoBo.salvar(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List<Endereco> lst = enderecoBo.listar(e.getLogradouro());

		if (!lst.isEmpty()) {
			e = lst.get(0);
			f.getEndereco().setId(e.getId());
		}

		return this.fornecedorBo.salvar(f);
	}

	public String editarFornecedor(Fornecedor f) throws Exception {
		return this.fornecedorBo.alterar(f);
	}

	public List<Fornecedor> listarFornecedor(String s) throws Exception {
		return this.fornecedorBo.listar(s);
	}

	public Fornecedor pegarFornecedor(String s) throws Exception {
		Fornecedor f = new Fornecedor();

		for (Fornecedor fo : this.fornecedorBo.listar(s)) {
			if (Integer.parseInt(s) == fo.getId()) {
				f = fo;
			}
		}

		return f;
	}

	public String excluirFornecedor(Fornecedor f) throws Exception {
		this.fornecedorBo.deletar(f);

		for (Endereco e : this.enderecoBo.listar("")) {
			if (e.getId() == f.getEndereco().getId()) {
				this.enderecoBo.deletar(e);
				break;
			}
		}

		return null;
	}

	// CIDADE
	public String salvarCidade(Cidade c) throws Exception {
		return this.cidadeBo.salvar(c);
	}

	public String editarCidade(Cidade c) throws Exception {
		return this.cidadeBo.alterar(c);
	}

	public String excluirCidade(Cidade c) throws Exception {
		return this.cidadeBo.deletar(c);
	}

	public List<Cidade> listarCidade(String s) throws Exception {
		return this.cidadeBo.listar(s);
	}

	// ESTADO
	public String salvarEstado(Estado e) throws Exception {
		return this.estadoBo.salvar(e);
	}

	public String editarEstado(Estado e) throws Exception {
		return this.estadoBo.alterar(e);
	}

	public String excluirEstado(Estado e) throws Exception {
		return this.estadoBo.deletar(e);
	}

	public List<Estado> listarEstado(String s) throws Exception {
		return this.estadoBo.listar(s);
	}

	// ENDEREÇO
	public String salvarEndereco(Endereco e) throws Exception {
		return this.enderecoBo.salvar(e);
	}

	public String editarEndereco(Endereco e) throws Exception {
		return this.enderecoBo.alterar(e);
	}

	public String excluirEndereco(Endereco e) throws Exception {
		return this.enderecoBo.deletar(e);
	}

	public List<Endereco> listarEndereco(String s) throws Exception {
		return this.enderecoBo.listar(s);
	}

	// COTAÇÃO-FORNECEDOR-PREÇO
	public String salvarCotacaoFornecedorPreco(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorPrecoBo.salvar(i);
	}

	public String editarCotacaoFornecedorPreco(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorPrecoBo.alterar(i);
	}

	public String excluirCotacaoFornecedorPreco(CotacaoFornecedorPreco i) throws Exception {
		return this.cotacaoFornecedorPrecoBo.deletar(i);
	}

	public List<CotacaoFornecedorPreco> listarCotacaoFornecedorPreco(String s) throws Exception {
		return this.cotacaoFornecedorPrecoBo.listar(s);
	}
	
	public List<CotacaoFornecedorPreco> listarCotacaoFornecedor(int id) throws Exception {
		List<CotacaoFornecedorPreco> lista = new ArrayList<CotacaoFornecedorPreco>();
		
		
		for(CotacaoFornecedorPreco cfp : this.cotacaoFornecedorPrecoBo.listar("")) {
			CotacaoFornecedorPreco cotacao = new CotacaoFornecedorPreco();
			if(cfp.getCotacaoItem().getId() == id) {
				cotacao = cfp;
			}
			for(Fornecedor f : this.fornecedorBo.listar("")) {
				if(cfp.getFornecedor().getId() == f.getId()) {
					cotacao.setFornecedor(f);
				}
			}
			lista.add(cotacao);
		}
		
		return lista;
	}

	// COTAÇÃO
	public int salvarCotacao(Cotacao cotacao) throws Exception {
		return this.cotacaoBo.salvar(cotacao);
	}

	public int lancarCotacao(Cotacao c) throws Exception {

		

		return this.cotacaoBo.salvar(c);
	}

	public void solicitarCotacao(List<OrdemCompra> pedidos) throws Exception {

		for (OrdemCompra pedido : pedidos) {
			Cotacao c = new Cotacao();
			CotacaoFornecedorPreco cfp = new CotacaoFornecedorPreco();
			

			c.getOrdemCompra().setId(pedido.getId());	
	
			int cod = this.cotacaoBo.salvar(c);
		
			
			List<Cotacao> listC = this.cotacaoBo.listar(cod);
			c = listC.get(0);
			
			
			
			
			for(OrdemCompraItem oci : pedido.getOrdemCompraItem()) {
				CotacaoItem ci = new CotacaoItem();
				
				ci.getCotacao().setId(c.getId());
				ci.setCotacaoForncedor(null);
				ci.setQuantidade(oci.getQuantidade());
				ci.setCodigo(oci.getCodigo());
				ci.getProduto().setId(oci.getProduto().getId());
				this.cotacaoItemBo.salvar(ci);
			}
			CotacaoItem ci = new CotacaoItem();
			List<CotacaoItem> listCi = this.cotacaoItemBo.listar("");
			ci = listCi.get(listCi.size()-1);
			
			cfp.getFornecedor().setId(pedido.getFornecedor().getId());
			cfp.getCotacaoItem().setId(ci.getId());
					
			this.cotacaoFornecedorPrecoBo.salvar(cfp);
			
		}
	}

	public String editarCotacao(Cotacao c) throws Exception {
		return this.cotacaoBo.alterar(c);
	}

	public String excluirCotacao(Cotacao c) throws Exception {
		return this.cotacaoBo.deletar(c);
	}

	public List<Cotacao> listarCotacao(long s) throws Exception {
		return this.cotacaoBo.listar(s);
	}

	// ORDEM-COMPRA
	public String salvarOrdemCompra(OrdemCompra e) throws Exception {
		return this.ordemCompraBo.salvar(e);
	}

	public String editarOrdemCompra(OrdemCompra e) throws Exception {
		return this.ordemCompraBo.alterar(e);
	}

	public String excluirOrdemCompra(OrdemCompra e) throws Exception {
		return this.ordemCompraBo.deletar(e);
	}

	public List<OrdemCompra> listarOrdemCompra(String e) throws Exception {
		return this.ordemCompraBo.listar(e);
	}

	public List<OrdemCompraItem> listarItensCompra(int oc) throws Exception {
		List<OrdemCompraItem> lista = new ArrayList<OrdemCompraItem>();

		for (OrdemCompraItem oci : this.ordemCompraItemBo.listar(0)) {
			
			if (oc == oci.getOrdem().getId()) {
				
				for(Produto p : this.produtoBo.listar("")) {
					if(p.getId() == oci.getProduto().getId()) {
						oci.setProduto(p);
						lista.add(oci);
					}
					
				}
				
				
			}
		}

		return lista;
	}

	public OrdemCompra novoPedido(List<String> requisicao, int id) throws Exception {
		OrdemCompra oc = new OrdemCompra();

		for (String r : requisicao) {
			OrdemCompraItem oci = new OrdemCompraItem();

			for (RequisicaoItem reqItem : this.requisicaoItemBo.listar("")) {
				if (Integer.parseInt(r) == reqItem.getId()) {

					for (Produto p : this.produtoBo.listar("")) {
						if (reqItem.getProduto().getId() == p.getId()) {
							long l = reqItem.getRequisicao().getCodigo();
							oci.setCodigo(l);
							oci.setProduto(p);
							oci.setQuantidade(reqItem.getQuantidade());
						}
					}

				}
			}

			oci.setValorUnitario(0);
			oci.setValorTotal(0);
			oc.getOrdemCompraItem().add(oci);
			oc.setId(id);
		}

		return oc;
	}

	public List<OrdemCompraItem> buscarProdutosPedido(int id) throws Exception {
		List<OrdemCompraItem> itens = new ArrayList<OrdemCompraItem>();
		for (OrdemCompraItem oci : this.ordemCompraItemBo.listar(0)) {
			if (oci.getOrdem().getId() == id) {
				itens.add(oci);
			}
		}

		return itens;
	}

	public void solicitarCompra(List<OrdemCompra> pedidos) throws Exception {

		for (OrdemCompra pedido : pedidos) {
			OrdemCompra oc = new OrdemCompra();
			int i = 0;

			oc.setId(0);
			oc.getFase().setId(2);
			oc.getSolicitante().setId(pedido.getSolicitante().getId());
			oc.getFornecedor().setId(pedido.getFornecedor().getId());
			oc.setDataEmissao(pedido.getDataEmissao());
			oc.setCotacao(null);

			this.ordemCompraBo.salvar(oc);

			List<OrdemCompra> ordem = this.ordemCompraBo.listar("");
			oc = ordem.get(ordem.size() - 1);
			i = oc.getId();

			for (OrdemCompraItem oci : pedido.getOrdemCompraItem()) {

				List<Produto> lista = this.produtoBo.listar(oci.getProduto().getNome());

				Produto p = lista.get(0);

				oci.setProduto(p);

				oci.getOrdem().setId(i);
				this.ordemCompraItemBo.salvar(oci);
			}
		}

	}

	// ORDEM-COMPRA-ITEM
	public String salvarOrdemCompraItem(OrdemCompraItem e) throws Exception {
		return this.ordemCompraItemBo.salvar(e);
	}

	public String editarOrdemCompraItem(OrdemCompraItem e) throws Exception {
		return this.ordemCompraItemBo.alterar(e);
	}

	public String excluirOrdemCompraItem(OrdemCompraItem e) throws Exception {
		return this.ordemCompraItemBo.deletar(e);
	}

	public List<OrdemCompraItem> listarOrdemCompraItem(long s) throws Exception {
		return this.ordemCompraItemBo.listar(s);
	}

	// NOTA-FISCAL
	public String salvarNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.salvar(e);
	}

	public String editarNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.alterar(e);
	}

	public String excluirNotaFiscal(NotaFiscal e) throws Exception {
		return this.notaFiscalBo.deletar(e);
	}

	public List<NotaFiscal> listarNotaFiscal(long e) throws Exception {
		return this.notaFiscalBo.listar(e);
	}
	
	public String lancarNota(OrdemCompra oc, NotaFiscal nf) throws Exception {
		
		
		nf.getFornecedor().setId(oc.getFornecedor().getId());
		nf.setItem(null);
		this.notaFiscalBo.salvar(nf);
		
		List<NotaFiscal> listNf = this.notaFiscalBo.listar(nf.getCodigo());
		nf = listNf.get(0);
		
		
		for(OrdemCompraItem oci : oc.getOrdemCompraItem()) {
			NotaFiscalItem nfi = new NotaFiscalItem();
			nfi.getNota().setId(nf.getId());
			nfi.getItem().setId(oci.getProduto().getId());
			nfi.setQuantidade(oci.getQuantidade());
			nfi.setValorUnitario(oci.getValorUnitario());
			nfi.setTotal(oci.getValorTotal());
			nfi.setCodigo((int) oci.getCodigo());
			this.notaFiscalItemBo.salvar(nfi);
		}
		
		return "";
	}

	// NOTA-FISCAL-ITEM
	public String salvarNotaFiscalItem(NotaFiscalItem e) throws Exception {
		return this.notaFiscalItemBo.salvar(e);
	}

	public String editarNotaFiscalItem(NotaFiscalItem e) throws Exception {
		return this.notaFiscalItemBo.alterar(e);
	}

	public String excluirNotaFiscalItem(NotaFiscalItem e) throws Exception {
		return this.notaFiscalItemBo.deletar(e);
	}

	public List<NotaFiscalItem> listarNotaFiscalItem(long s) throws Exception {
		return this.notaFiscalItemBo.listar(s);
	}

	// FASE
	public String salvarFase(Fase e) throws Exception {
		return this.faseBo.salvar(e);
	}

	public String editarFase(Fase e) throws Exception {
		return this.faseBo.alterar(e);
	}

	public String excluirFase(Fase e) throws Exception {
		return this.faseBo.deletar(e);
	}

	public List<Fase> listarFase(int s) throws Exception {
		return this.faseBo.listar(s);
	}

	// ORIGEM
	public String salvarOrigem(Origem e) throws Exception {
		return this.origemBo.salvar(e);
	}

	public String editarOrigem(Origem e) throws Exception {
		return this.origemBo.alterar(e);
	}

	public String excluirOrigem(Origem e) throws Exception {
		return this.origemBo.deletar(e);
	}

	public List<Origem> listarOrigem(String s) throws Exception {
		return this.origemBo.listar(s);
	}

	// REQUISIÇÃO
	public String salvarRequisicao(Requisicao e, List<RequisicaoItem> i) throws Exception {

		e.getFase().setId(1);
		e.getFase().setStatus(1);

		int codigo = this.requisicaoBo.salvar(e);
		int id = 0;

		for (Requisicao r : this.requisicaoBo.listar(codigo)) {
			if (r.getCodigo() == codigo) {
				id = r.getId();
				break;
			}
		}

		for (RequisicaoItem ri : i) {
			ri.getRequisicao().setId(id);
			this.requisicaoItemBo.salvar(ri);
		}

		return "";
	}

	public String editarRequisicao(Requisicao e) throws Exception {
		return this.requisicaoBo.alterar(e);
	}

	public String excluirRequisicao(Requisicao e) throws Exception {
		return this.requisicaoBo.deletar(e);
	}

	public List<Requisicao> listarRequisicao(int s) throws Exception {
		return this.requisicaoBo.listar(s);
	}

	// REQUISIÇÃO-ITEM
	public String salvarRequisicaoItem(RequisicaoItem e) throws Exception {
		return this.requisicaoItemBo.salvar(e);
	}

	public String editarRequisicaoItem(RequisicaoItem e) throws Exception {
		return this.requisicaoItemBo.alterar(e);
	}

	public String excluirRequisicaoItem(RequisicaoItem e) throws Exception {
		return this.requisicaoItemBo.deletar(e);
	}

	public List<RequisicaoItem> listarRequisicaoItem(String s) throws Exception {
		return this.requisicaoItemBo.listar(s);
	}

	public RequisicaoItem pegarProduto(RequisicaoItem r) throws Exception {

		for (Produto p : this.produtoBo.listar("")) {
			if (p.getId() == r.getProduto().getId()) {
				r.setProduto(p);
			}
		}

		return r;
	}

	public List<RequisicaoItem> listarItens(Requisicao r) throws Exception {
		List<RequisicaoItem> itens = new ArrayList<RequisicaoItem>();

		for (RequisicaoItem ri : this.requisicaoItemBo.listar("")) {
			if (ri.getRequisicao().getId() == r.getId()) {
				for (Produto p : this.produtoBo.listar("")) {
					if (ri.getProduto().getId() == p.getId()) {
						ri.setProduto(p);
					}
				}
				itens.add(ri);
			}
		}

		return itens;
	}

	// FISCAL-ITEM
	public String salvarFiscalItem(FiscalItem e) throws Exception {
		return this.fiscalItemBo.salvar(e);
	}

	public String editarFiscalItem(FiscalItem e) throws Exception {
		return this.fiscalItemBo.alterar(e);
	}

	public String excluirFiscalItem(FiscalItem e) throws Exception {
		return this.fiscalItemBo.deletar(e);
	}

	public List<FiscalItem> listarFiscalItem(String s) throws Exception {
		return this.fiscalItemBo.listar(s);
	}

	// COTAÇÃO-ITEM
	public String salvarCotacaoItem(CotacaoItem e) throws Exception {
		return this.cotacaoItemBo.salvar(e);
	}

	public String editarCotacaoItem(CotacaoItem e) throws Exception {
		return this.cotacaoItemBo.alterar(e);
	}

	public String excluirCotacaoItem(CotacaoItem e) throws Exception {
		return this.cotacaoItemBo.deletar(e);
	}

	public List<CotacaoItem> listarCotacaoItem(String s) throws Exception {
		return this.cotacaoItemBo.listar(s);
	}
	
	public List<CotacaoItem> listarItensCotacao(int id) throws Exception {
		List<CotacaoItem> itens = new ArrayList<>();
		
		for(CotacaoItem ci : this.cotacaoItemBo.listar("")) {
			if(id == ci.getCotacao().getId()) {
				for(Produto p : this.produtoBo.listar("")) {
					if(ci.getProduto().getId() == p.getId()) {
						ci.setProduto(p);
						itens.add(ci);
					}
				}
			}
		}
		
		return itens;
	}

}