package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.CotacaoFornecedorPrecoDao;
import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;

public class CotacaoFornecedorPrecoBo {
	
	public String salvar(CotacaoFornecedorPreco cotacaofornecedoritem) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(cotacaofornecedoritem);
		CotacaoFornecedorPrecoDao cotacaofornecedoritemDao = new CotacaoFornecedorPrecoDao();
		try {
			return cotacaofornecedoritemDao.salvar(cotacaofornecedoritem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(CotacaoFornecedorPreco cotacaofornecedoritem) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(cotacaofornecedoritem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoFornecedorPrecoDao().alterar(cotacaofornecedoritem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(CotacaoFornecedorPreco cotacaofornecedoritem) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(cotacaofornecedoritem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoFornecedorPrecoDao().deletar(cotacaofornecedoritem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<CotacaoFornecedorPreco> listar(String paramNome) throws Exception {
		try {
			return new CotacaoFornecedorPrecoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosFornecedorPedidoCotacao(CotacaoFornecedorPreco cotacaofornecedoritem) throws Exception {
//		if (cotacaofornecedoritem.getId() < 0) {
//			throw new Exception("Id do cotacaofornecedoritem n�o pode ser negativo!");
//		}
		if (cotacaofornecedoritem == null) {
			throw new Exception("Objeto nullo!");
		}
	}	
	
}
