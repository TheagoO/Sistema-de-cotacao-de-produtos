package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.PedidoCompraDao;
import br.edu.unifacear.model.entity.PedidoCompra;

public class PedidoCompraBo {
	
	public String salvar(PedidoCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		PedidoCompraDao pedidocompraDao = new PedidoCompraDao();
		try {
			return pedidocompraDao.salvar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PedidoCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCompraDao().alterar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PedidoCompra pedidocompra) 
			throws Exception {
		validarDadosPedidoCompra(pedidocompra);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCompraDao().deletar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoCompra> listar(String paramNome) throws Exception {
		try {
			return new PedidoCompraDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
		

	private void validarDadosPedidoCompra(PedidoCompra pedidocompra) throws Exception {
//		if (pedidocompra.getId() < 0) {
//			throw new Exception("Id do pedidocompra não pode ser negativo!");
//		}
		if (pedidocompra.toString().equals("")) {
			throw new Exception("Nome do pedido compra não pode ficar em branco!");
		}
	}	
	
}
