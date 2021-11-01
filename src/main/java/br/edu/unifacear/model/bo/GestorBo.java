package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.GestorDao;
import br.edu.unifacear.model.entity.Gestor;

public class GestorBo {

	public String salvar(Gestor gestor) throws Exception {
		validarDadosGestor(gestor, "salvar");
		GestorDao gestorDao = new GestorDao();
		try {
			return gestorDao.salvar(gestor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String alterar(Gestor gestor) throws Exception {
		validarDadosGestor(gestor, "");
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new GestorDao().alterar(gestor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Gestor gestor) throws Exception {

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

	private void validarDadosGestor(Gestor g, String s) throws Exception {

	}

}
