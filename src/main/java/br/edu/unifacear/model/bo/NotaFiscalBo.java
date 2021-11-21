package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.NotaFiscalDao;
import br.edu.unifacear.model.entity.NotaFiscal;

public class NotaFiscalBo {
	
	public String salvar(NotaFiscal notaFiscal) 
			throws Exception {
	
		NotaFiscalDao notaFiscalDao = new NotaFiscalDao();
		try {
			return notaFiscalDao.salvar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(NotaFiscal notaFiscal) 
			throws Exception {
		
		try {
			return new NotaFiscalDao().alterar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(NotaFiscal notaFiscal) 
			throws Exception {
		
		try {
			return new NotaFiscalDao().deletar(notaFiscal);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<NotaFiscal> listar(long paramNome) throws Exception {
		try {
			return new NotaFiscalDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
}
