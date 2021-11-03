package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.PedidoCompraDao;
import br.edu.unifacear.model.entity.PedidoCompra;

public class PedidoCompraBo {
	
	public String salvar(PedidoCompra pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		PedidoCompraDao pedidoitemDao = new PedidoCompraDao();
		try {
			return pedidoitemDao.salvar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PedidoCompra pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCompraDao().alterar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PedidoCompra pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoCompraDao().deletar(pedidoitem);
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
	
	
	private void validarDadosPedidoItem(PedidoCompra pedidoitem) throws Exception {

	}	
	
}
