package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.FaseDao;
import br.edu.unifacear.model.entity.Fase;

public class FaseBo {
	
	public String salvar(Fase status) 
			throws Exception {
		
		try {
			return new FaseDao().salvar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Fase status) 
			throws Exception {

		try {
			return new FaseDao().alterar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Fase status) 
			throws Exception {

		try {
			return new FaseDao().deletar(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Fase> listar(int paramNome) throws Exception {
		try {
			return new FaseDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	
}
