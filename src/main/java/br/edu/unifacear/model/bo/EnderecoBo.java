package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.EnderecoDao;
import br.edu.unifacear.model.entity.Endereco;

public class EnderecoBo {
	
	public String salvar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		EnderecoDao enderecoDao = new EnderecoDao();
		try {
			return enderecoDao.salvar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new EnderecoDao().alterar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		// exemplo chamando a DAO com a instancia direta do obj
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
	


	private void validarDadosEndereco(Endereco endereco) throws Exception {
//		if (endereco.getId() < 0) {
//			throw new Exception("Id do endereco não pode ser negativo!");
//		}
		if (endereco.getCidade().getNome().equals("")) {
			throw new Exception("Nome do endereco não pode ficar em branco!");
		}
	}	
	
}
