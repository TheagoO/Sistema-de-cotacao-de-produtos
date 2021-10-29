package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.OrdemCompraDao;
import br.edu.unifacear.model.entity.OrdemCompra;

public class OrdemCompraBo {
	
	public String salvar(OrdemCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		OrdemCompraDao pedidocompraDao = new OrdemCompraDao();
		try {
			return pedidocompraDao.salvar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(OrdemCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new OrdemCompraDao().alterar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(OrdemCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new OrdemCompraDao().deletar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<OrdemCompra> listar(String paramNome) throws Exception {
		try {
			return new OrdemCompraDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
		

	private void validarDadosPedidoCompra(OrdemCompra pedidocompra) throws Exception {
//		if (pedidocompra.getId() < 0) {
//			throw new Exception("Id do pedidocompra não pode ser negativo!");
//		}
		if (pedidocompra.toString().equals("")) {
			throw new Exception("Nome do pedido compra não pode ficar em branco!");
		}
	}	
	
}
