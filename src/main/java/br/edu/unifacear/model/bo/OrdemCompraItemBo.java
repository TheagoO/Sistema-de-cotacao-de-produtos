package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.OrdemCompraItemDao;
import br.edu.unifacear.model.entity.RequisicaoItem;

public class OrdemCompraItemBo {
	
	public String salvar(RequisicaoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		OrdemCompraItemDao pedidoitemDao = new OrdemCompraItemDao();
		try {
			return pedidoitemDao.salvar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(RequisicaoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new OrdemCompraItemDao().alterar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(RequisicaoItem pedidoitem) 
			throws Exception {
		validarDadosPedidoItem(pedidoitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new OrdemCompraItemDao().deletar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<RequisicaoItem> listar(String paramNome) throws Exception {
		try {
			return new OrdemCompraItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	private void validarDadosPedidoItem(RequisicaoItem pedidoitem) throws Exception {

	}	
	
}
