package br.edu.unifacear.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.edu.unifacear.controller.PaisController;
import br.edu.unifacear.model.entity.Pais;

@ManagedBean(name = "paisBean")
@ViewScoped
public class PaisBean {
	
	private PaisController paisController;
	private Pais pais;
	
	public PaisBean() {
		this.pais = new Pais();
	}
		
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public List<Pais> getOrigem() throws Exception {
		paisController = new PaisController();
		return paisController.listarPais();
	}
	
	public String salvarPais() throws Exception {
		paisController = new PaisController();
		return paisController.salvar(pais);
	}
	
}
