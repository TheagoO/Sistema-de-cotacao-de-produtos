package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.RequisicaoDao;
import br.edu.unifacear.model.entity.Requisicao;

public class RequisicaoBo {
	
	public String salvar(Requisicao requisicao) 
			throws Exception {
		RequisicaoDao requisicaoDao = new RequisicaoDao();
		try {
			return requisicaoDao.salvar(requisicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Requisicao requisicao) 
			throws Exception {
		try {
			return new RequisicaoDao().alterar(requisicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Requisicao requisicao) 
			throws Exception {
		try {
			return new RequisicaoDao().deletar(requisicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Requisicao> listar(long paramNome) throws Exception {
		try {
			return new RequisicaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		

}
