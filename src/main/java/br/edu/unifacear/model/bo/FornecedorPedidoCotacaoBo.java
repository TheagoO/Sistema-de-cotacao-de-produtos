package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.FornecedorPedidoCotacaoDao;
import br.edu.unifacear.model.entity.FornecedorPedidoCotacao;

public class FornecedorPedidoCotacaoBo {
	
	public String salvar(FornecedorPedidoCotacao fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		FornecedorPedidoCotacaoDao fornecedorDao = new FornecedorPedidoCotacaoDao();
		try {
			return fornecedorDao.salvar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(FornecedorPedidoCotacao fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FornecedorPedidoCotacaoDao().alterar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(FornecedorPedidoCotacao fornecedor) 
			throws Exception {
		validarDadosFornecedorPedidoCotacao(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FornecedorPedidoCotacaoDao().deletar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<FornecedorPedidoCotacao> listar(String paramNome) throws Exception {
		try {
			return new FornecedorPedidoCotacaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosFornecedorPedidoCotacao(FornecedorPedidoCotacao fornecedor) throws Exception {
//		if (fornecedor.getId() < 0) {
//			throw new Exception("Id do fornecedor não pode ser negativo!");
//		}
		if (fornecedor == null) {
			throw new Exception("Objeto nullo!");
		}
	}	
	
}
