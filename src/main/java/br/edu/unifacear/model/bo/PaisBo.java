package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.PaisDao;
import br.edu.unifacear.model.entity.Pais;

public class PaisBo {
	
	public String salvar(Pais pais) 
			throws Exception {
		PaisDao paisDao = new PaisDao();
		try {
			return paisDao.salvar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Pais pais) 
			throws Exception {
		try {
			return new PaisDao().alterar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Pais pais) 
			throws Exception {
		try {
			return new PaisDao().deletar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Pais> listar(String paramNome) throws Exception {
		try {
			return new PaisDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		

}
