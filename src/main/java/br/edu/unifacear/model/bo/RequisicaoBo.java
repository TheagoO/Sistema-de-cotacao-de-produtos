package br.edu.unifacear.model.bo;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import br.edu.unifacear.model.dao.RequisicaoDao;
import br.edu.unifacear.model.entity.Requisicao;

public class RequisicaoBo {
	
	public int salvar(Requisicao requisicao) 
			throws Exception {
		RequisicaoDao requisicaoDao = new RequisicaoDao();
		Random r = new Random();
		int cod =  r.nextInt(99999);
		try {
			
			requisicao.setCodigo(cod);
			requisicaoDao.salvar(requisicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return cod;
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
	
	public List<Requisicao> listar(int paramNome) throws Exception {
		try {
			return new RequisicaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		

}
