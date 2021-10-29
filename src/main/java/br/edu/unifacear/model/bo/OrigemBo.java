package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.OrigemDao;
import br.edu.unifacear.model.entity.Origem;

public class OrigemBo {
	
	public String salvar(Origem pais) 
			throws Exception {
		OrigemDao paisDao = new OrigemDao();
		try {
			return paisDao.salvar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Origem pais) 
			throws Exception {
		try {
			return new OrigemDao().alterar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Origem pais) 
			throws Exception {
		try {
			return new OrigemDao().deletar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Origem> listar(String paramNome) throws Exception {
		try {
			return new OrigemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		

}
