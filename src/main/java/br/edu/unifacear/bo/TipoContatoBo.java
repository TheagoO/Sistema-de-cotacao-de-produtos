package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.TipoContato;
import br.edu.unifacear.dao.TipoContatoDao;

public class TipoContatoBo {
	
	public String salvar(TipoContato tipocontato) 
			throws Exception {
		validarDadosTipoContato(tipocontato);
		TipoContatoDao tipocontatoDao = new TipoContatoDao();
		try {
			return tipocontatoDao.salvar(tipocontato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(TipoContato tipocontato) 
			throws Exception {
		validarDadosTipoContato(tipocontato);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new TipoContatoDao().alterar(tipocontato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(TipoContato tipocontato) 
			throws Exception {
		validarDadosTipoContato(tipocontato);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new TipoContatoDao().deletar(tipocontato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<TipoContato> listar(String paramNome) throws Exception {
		try {
			return new TipoContatoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	
	private void validarDadosTipoContato(TipoContato tipocontato) throws Exception {
//		if (tipocontato.getId() < 0) {
//			throw new Exception("Id do tipocontato não pode ser negativo!");
//		}
		if (tipocontato.getNome().equals("")) {
			throw new Exception("Nome do tipo contato não pode ficar em branco!");
		}
	}	
	
}
