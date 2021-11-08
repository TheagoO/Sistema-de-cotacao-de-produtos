package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.NotaFiscalItemDao;
import br.edu.unifacear.model.entity.NotaFiscalItem;

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
	
	public List<NotaFiscalItem> listar(long paramNome) throws Exception {
		try {
			return new NotaFiscalItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosNotaFiscalItem(NotaFiscalItem notafiscalitem) throws Exception {
//		if (notafiscalitem.getId() < 0) {
//			throw new Exception("Id do notafiscalitem não pode ser negativo!");
//		}
		if (notafiscalitem.getItem().getNome().equals("")) {
			throw new Exception("Nome do nota fiscal item não pode ficar em branco!");
		}
	}	
	
}
