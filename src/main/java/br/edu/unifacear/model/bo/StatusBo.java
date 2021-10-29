package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.StatusDao;
import br.edu.unifacear.model.entity.Status;

public class StatusBo {
	
	public String salvar(Status status) 
			throws Exception {
		validarDadosPedidoItem(status);
		StatusDao statusDao = new StatusDao();
		try {
			return statusDao.salvar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Status status) 
			throws Exception {
		validarDadosPedidoItem(status);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new StatusDao().alterar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Status status) 
			throws Exception {
		validarDadosPedidoItem(status);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new StatusDao().deletar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Status> listar(String paramNome) throws Exception {
		try {
			return new StatusDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	private void validarDadosPedidoItem(Status status) throws Exception {
//		if (status.getId() < 0) {
//			throw new Exception("Id do status não pode ser negativo!");
//		}
		if (status.getStatus().equals("")) {
			throw new Exception("Nome do status não pode ficar em branco!");
		}
	}	
}
