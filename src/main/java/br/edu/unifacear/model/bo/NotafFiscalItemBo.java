package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.NotaFiscalItemDao;
import br.edu.unifacear.model.entity.NotaFiscalItem;

public class NotafFiscalItemBo {
	
	public String salvar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		
		NotaFiscalItemDao notafiscalitemDao = new NotaFiscalItemDao();
		try {
			return notafiscalitemDao.salvar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		
		try {
			return new NotaFiscalItemDao().alterar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		
		try {
			return new NotaFiscalItemDao().deletar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<NotaFiscalItem> listar(long paramNome) throws Exception {
		try {
			return new NotaFiscalItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	


	
}
