package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.PedidoCotacaoDao;
import br.edu.unifacear.model.entity.PedidoCotacao;

public class PedidoCotacaoBo {
	
	public String salvar(PedidoCotacao pedidocotacao) 
			throws Exception {
		validarDadosPedidoCotacao(pedidocotacao);
		PedidoCotacaoDao pedidocotacaoDao = new PedidoCotacaoDao();
		try {
			return pedidocotacaoDao.salvar(pedidocotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PedidoCotacao pedidocotacao) 
			throws Exception {
		validarDadosPedidoCotacao(pedidocotacao);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCotacaoDao().alterar(pedidocotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PedidoCotacao pedidocotacao) 
			throws Exception {
		validarDadosPedidoCotacao(pedidocotacao);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCotacaoDao().deletar(pedidocotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoCotacao> listar(String paramNome) throws Exception {
		try {
			return new PedidoCotacaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosPedidoCotacao(PedidoCotacao pedidocotacao) throws Exception {
//		if (pedidocotacao.getId() < 0) {
//			throw new Exception("Id do pedidocotacao não pode ser negativo!");
//		}
		if (pedidocotacao.toString().equals("")) {
			throw new Exception("Nome do pedidocotacao não pode ficar em branco!");
		}
	}	
	
}
