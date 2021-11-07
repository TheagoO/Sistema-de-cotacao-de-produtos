package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.RequisicaoDao;
import br.edu.unifacear.model.entity.Requisicao;

public class OrdemCompraBo {
	
	public String salvar(Requisicao pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		RequisicaoDao pedidocompraDao = new RequisicaoDao();
		try {
			return pedidocompraDao.salvar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Requisicao pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new RequisicaoDao().alterar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Requisicao pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new RequisicaoDao().deletar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Requisicao> listar(String paramNome) throws Exception {
		try {
			return new RequisicaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
		

	private void validarDadosPedidoCompra(Requisicao pedidocompra) throws Exception {
//		if (pedidocompra.getId() < 0) {
//			throw new Exception("Id do pedidocompra não pode ser negativo!");
//		}
		if (pedidocompra.toString().equals("")) {
			throw new Exception("Nome do pedido compra não pode ficar em branco!");
		}
	}	
	
}
