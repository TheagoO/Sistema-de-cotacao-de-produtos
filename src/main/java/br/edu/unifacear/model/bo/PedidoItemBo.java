package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.PedidoItemDao;
import br.edu.unifacear.model.entity.PedidoItem;

public class PedidoItemBo {
	
	public String salvar(PedidoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		PedidoItemDao pedidoitemDao = new PedidoItemDao();
		try {
			return pedidoitemDao.salvar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PedidoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoItemDao().alterar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PedidoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoItemDao().deletar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoItem> listar(String paramNome) throws Exception {
		try {
			return new PedidoItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	private void validarDadosPedidoItem(PedidoItem pedidoitem) throws Exception {
//		if (pedidoitem.getId() < 0) {
//			throw new Exception("Id do pedidoitem não pode ser negativo!");
//		}
		if (pedidoitem.getItem().equals("")) {
			throw new Exception("Nome do pedido item não pode ficar em branco!");
		}
	}	
	
}
