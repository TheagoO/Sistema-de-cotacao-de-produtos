package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.NotaFiscalDao;
import br.edu.unifacear.model.entity.NotaFiscal;

public class NotaFiscalBo {
	
	public String salvar(NotaFiscal notaFiscal) 
			throws Exception {
		validarDadosNotaFiscal(notaFiscal);
		NotaFiscalDao notaFiscalDao = new NotaFiscalDao();
		try {
			return notaFiscalDao.salvar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(NotaFiscal notaFiscal) 
			throws Exception {
		validarDadosNotaFiscal(notaFiscal);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new NotaFiscalDao().alterar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(NotaFiscal notaFiscal) 
			throws Exception {
		validarDadosNotaFiscal(notaFiscal);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new NotaFiscalDao().deletar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<NotaFiscal> listar(String paramNome) throws Exception {
		try {
			return new NotaFiscalDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosNotaFiscal(NotaFiscal notaFiscal) throws Exception {
//		if (notaFiscal.getId() < 0) {
//			throw new Exception("Id do notaFiscal não pode ser negativo!");
//		}
		if (notaFiscal.getFornecedor().getNome().equals("")) {
			throw new Exception("Nome do nota fiscal não pode ficar em branco!");
		}
	}	
	
}
