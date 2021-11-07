package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.FaseDao;
import br.edu.unifacear.model.entity.Fase;

public class FaseBo {
	
	public String salvar(Fase status) 
			throws Exception {
		validarDadosPedidoItem(status);
		FaseDao statusDao = new FaseDao();
		try {
			return statusDao.salvar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Fase status) 
			throws Exception {
		validarDadosPedidoItem(status);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FaseDao().alterar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Fase status) 
			throws Exception {
		validarDadosPedidoItem(status);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FaseDao().deletar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Fase> listar(String paramNome) throws Exception {
		try {
			return new FaseDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	private void validarDadosPedidoItem(Fase status) throws Exception {
//		if (status.getId() < 0) {
//			throw new Exception("Id do status não pode ser negativo!");
//		}
		if (status.getStatus().equals("")) {
			throw new Exception("Nome do status não pode ficar em branco!");
		}
	}	
}
