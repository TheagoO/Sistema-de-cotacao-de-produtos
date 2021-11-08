package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.OrdemCompraItemDao;
import br.edu.unifacear.model.entity.OrdemCompraItem;

public class OrdemCompraItemBo {
	
	public String salvar(OrdemCompraItem pedidoitem) 
			throws Exception {

		OrdemCompraItemDao pedidoitemDao = new OrdemCompraItemDao();
		try {
			return pedidoitemDao.salvar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(OrdemCompraItem pedidoitem) 
			throws Exception {

		try {
			return new OrdemCompraItemDao().alterar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(OrdemCompraItem pedidoitem) 
			throws Exception {
		
		try {
			return new OrdemCompraItemDao().deletar(pedidoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<OrdemCompraItem> listar(long paramNome) throws Exception {
		try {
			return new OrdemCompraItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
}
