package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.Cidade;
import br.edu.unifacear.dao.CidadeDao;

public class CidadeBo {
	
	public String salvar(Cidade cidade) 
			throws Exception {
		validarDadosCidade(cidade);
		CidadeDao cidadeDao = new CidadeDao();
		try {
			return cidadeDao.salvar(cidade);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Cidade cidade) 
			throws Exception {
		validarDadosCidade(cidade);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CidadeDao().alterar(cidade);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Cidade cidade) 
			throws Exception {
		validarDadosCidade(cidade);
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
	
	

	private void validarDadosCidade(Cidade cidade) throws Exception {
//		if (cidade.getId() < 0) {
//			throw new Exception("Id do cidade n�o pode ser negativo!");
//		}
		if (cidade.getNome().equals("")) {
			throw new Exception("Nome do cidade n�o pode ficar em branco!");
		}
	}	
	
}
