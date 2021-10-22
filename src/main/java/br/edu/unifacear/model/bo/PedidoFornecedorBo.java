package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.PedidoFornecedorDao;
import br.edu.unifacear.model.entity.PedidoFornecedor;

public class PedidoFornecedorBo {
	
	public String salvar(PedidoFornecedor pedidoforn) 
			throws Exception {
		validarDadosPedidoFornecedor(pedidoforn);
		PedidoFornecedorDao pedidofornDao = new PedidoFornecedorDao();
		try {
			return pedidofornDao.salvar(pedidoforn);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PedidoFornecedor pedidoforn) 
			throws Exception {
		validarDadosPedidoFornecedor(pedidoforn);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoFornecedorDao().alterar(pedidoforn);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PedidoFornecedor pedidoforn) 
			throws Exception {
		validarDadosPedidoFornecedor(pedidoforn);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new PedidoFornecedorDao().deletar(pedidoforn);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoFornecedor> listar(String paramNome) throws Exception {
		try {
			return new PedidoFornecedorDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosPedidoFornecedor(PedidoFornecedor pedidoforn) throws Exception {
//		if (pedidoforn.getId() < 0) {
//			throw new Exception("Id do pedidoforn não pode ser negativo!");
//		}
		if (pedidoforn.getFornecedor().equals("")) {
			throw new Exception("Nome do pedido fornecedor não pode ficar em branco!");
		}
	}	
	
}
