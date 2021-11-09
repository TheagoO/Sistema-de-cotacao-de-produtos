package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.CidadeDao;
import br.edu.unifacear.model.entity.Cidade;

public class CidadeBo {
	
	public String salvar(Cidade cidade) 
			throws Exception {
		CidadeDao cidadeDao = new CidadeDao();
		try {
			return cidadeDao.salvar(cidade);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Cidade cidade) 
			throws Exception {
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CidadeDao().alterar(cidade);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Cidade cidade) 
			throws Exception {
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CidadeDao().deletar(cidade);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Cidade> listar(String paramNome) throws Exception {
		try {
			return new CidadeDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
		
}
