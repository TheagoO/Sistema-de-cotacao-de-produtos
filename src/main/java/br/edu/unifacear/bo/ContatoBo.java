package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.Contato;
import br.edu.unifacear.dao.ContatoDao;

public class ContatoBo {
	
	public String salvar(Contato contato) 
			throws Exception {
		validarDadosContato(contato);
		ContatoDao contatoDao = new ContatoDao();
		try {
			return contatoDao.salvar(contato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Contato contato) 
			throws Exception {
		validarDadosContato(contato);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ContatoDao().alterar(contato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Contato contato) 
			throws Exception {
		validarDadosContato(contato);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ContatoDao().deletar(contato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Contato> listar(String paramNome) throws Exception {
		try {
			return new ContatoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosContato(Contato contato) throws Exception {
//		if (contato.getId() < 0) {
//			throw new Exception("Id do contato não pode ser negativo!");
//		}
		if (contato.getContato().equals("")) {
			throw new Exception("Nome do contato não pode ficar em branco!");
		}
	}	
	
}
