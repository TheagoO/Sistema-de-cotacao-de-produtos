package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.CotacaoFornecedorDao;
import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;

public class CotacaoFornecedorBo {
	
	public String salvar(CotacaoFornecedorPreco fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		CotacaoFornecedorDao fornecedorDao = new CotacaoFornecedorDao();
		try {
			return fornecedorDao.salvar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(CotacaoFornecedorPreco fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoFornecedorDao().alterar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(CotacaoFornecedorPreco fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoFornecedorDao().deletar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<CotacaoFornecedorPreco> listar(String paramNome) throws Exception {
		try {
			return new CotacaoFornecedorDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosFornecedorPedidoCotacao(CotacaoFornecedorPreco fornecedor) throws Exception {
//		if (fornecedor.getId() < 0) {
//			throw new Exception("Id do fornecedor não pode ser negativo!");
//		}
		if (fornecedor == null) {
			throw new Exception("Objeto nullo!");
		}
	}	
	
}
