package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.RequisicaoItemDao;
import br.edu.unifacear.model.entity.RequisicaoItem;

public class RequisicaoItemBo {
	
	public String salvar(RequisicaoItem requisicaoitem) 
			throws Exception {
		RequisicaoItemDao requisicaoitemDao = new RequisicaoItemDao();
		try {
			return requisicaoitemDao.salvar(requisicaoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(RequisicaoItem requisicaoitem) 
			throws Exception {
		try {
			return new RequisicaoItemDao().alterar(requisicaoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(RequisicaoItem requisicaoitem) 
			throws Exception {
		try {
			return new RequisicaoItemDao().deletar(requisicaoitem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<RequisicaoItem> listar(String paramNome) throws Exception {
		try {
			return new RequisicaoItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		

}
