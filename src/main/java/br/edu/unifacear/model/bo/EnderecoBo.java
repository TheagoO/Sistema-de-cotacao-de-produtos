package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.EnderecoDao;
import br.edu.unifacear.model.entity.Endereco;

public class EnderecoBo {
	
	public String salvar(Endereco endereco) 
			throws Exception {
		EnderecoDao enderecoDao = new EnderecoDao();
		try {
			return enderecoDao.salvar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Endereco endereco) 
			throws Exception {

		try {
			return new EnderecoDao().alterar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Endereco endereco) 
			throws Exception {
		try {
			return new EnderecoDao().deletar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Endereco> listar(String paramNome) throws Exception {
		try {
			return new EnderecoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
}
