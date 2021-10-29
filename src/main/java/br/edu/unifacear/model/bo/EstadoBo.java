package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.EstadoDao;
import br.edu.unifacear.model.entity.Estado;

public class EstadoBo {
	
	public String salvar(Estado estado) 
			throws Exception {
		validarDadosEstado(estado);
		EstadoDao estadoDao = new EstadoDao();
		try {
			return estadoDao.salvar(estado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Estado estado) 
			throws Exception {
		validarDadosEstado(estado);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new EstadoDao().alterar(estado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Estado estado) 
			throws Exception {
		validarDadosEstado(estado);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new EstadoDao().deletar(estado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Estado> listar(String paramNome) throws Exception {
		try {
			return new EstadoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosEstado(Estado estado) throws Exception {
//		if (estado.getId() < 0) {
//			throw new Exception("Id do estado não pode ser negativo!");
//		}
		if (estado.getNome().equals("")) {
			throw new Exception("Nome do estado não pode ficar em branco!");
		}
	}	
	
}
