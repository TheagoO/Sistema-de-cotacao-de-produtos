package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.Gestor;
import br.edu.unifacear.dao.GestorDao;

public class GestorBo {
	
	public String salvar(Gestor gestor) 
			throws Exception {
		validarDadosGestor(gestor);
		GestorDao gestorDao = new GestorDao();
		try {
			return gestorDao.salvar(gestor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Gestor gestor) 
			throws Exception {
		validarDadosGestor(gestor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new GestorDao().alterar(gestor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Gestor gestor) 
			throws Exception {
		validarDadosGestor(gestor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new GestorDao().deletar(gestor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Gestor> listar(String paramNome) throws Exception {
		try {
			return new GestorDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
		

	private void validarDadosGestor(Gestor gestor) throws Exception {
//		if (gestor.getId() < 0) {
//			throw new Exception("Id do gestor não pode ser negativo!");
//		}
		if (gestor.getNome().equals("")) {
			throw new Exception("Nome do gestor não pode ficar em branco!");
		}
	}	
	
}
