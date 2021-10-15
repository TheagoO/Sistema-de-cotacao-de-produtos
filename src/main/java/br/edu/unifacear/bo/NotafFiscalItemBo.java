package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.NotaFiscalItem;
import br.edu.unifacear.dao.NotaFiscalItemDao;

public class NotafFiscalItemBo {
	
	public String salvar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		validarDadosNotaFiscalItem(notafiscalitem);
		NotaFiscalItemDao notafiscalitemDao = new NotaFiscalItemDao();
		try {
			return notafiscalitemDao.salvar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		validarDadosNotaFiscalItem(notafiscalitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new NotaFiscalItemDao().alterar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(NotaFiscalItem notafiscalitem) 
			throws Exception {
		validarDadosNotaFiscalItem(notafiscalitem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new NotaFiscalItemDao().deletar(notafiscalitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<NotaFiscalItem> listar(String paramNome) throws Exception {
		try {
			return new NotaFiscalItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosNotaFiscalItem(NotaFiscalItem notafiscalitem) throws Exception {
//		if (notafiscalitem.getId() < 0) {
//			throw new Exception("Id do notafiscalitem n�o pode ser negativo!");
//		}
		if (notafiscalitem.getItem().equals("")) {
			throw new Exception("Nome do nota fiscal item n�o pode ficar em branco!");
		}
	}	
	
}