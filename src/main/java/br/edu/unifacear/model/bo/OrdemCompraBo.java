package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.OrdemCompraDao;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.OrdemCompra;

public class OrdemCompraBo {
	
	OrdemCompraDao ordemCompraDao;
	
	public String salvar(OrdemCompra pedidocompra) 
			throws Exception {
		ordemCompraDao = new OrdemCompraDao();
		try {
			return ordemCompraDao.salvar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(OrdemCompra pedidocompra) 
			throws Exception {
		ordemCompraDao = new OrdemCompraDao();
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return ordemCompraDao.alterar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(OrdemCompra pedidocompra) 
			throws Exception {
		ordemCompraDao = new OrdemCompraDao();
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return ordemCompraDao.deletar(pedidocompra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<OrdemCompra> listar(String paramNome) throws Exception {
		ordemCompraDao = new OrdemCompraDao();
		try {
			return ordemCompraDao.listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
		

}
