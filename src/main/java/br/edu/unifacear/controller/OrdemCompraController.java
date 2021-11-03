package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.PedidoCompra;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraBean")
@ApplicationScoped
public class OrdemCompraController {
	
	private OrdemCompra ordem;
	private List<OrdemCompra> lista;
	private Item selecionado;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarOrdemCompra(ordem);
			this.ordem = new OrdemCompra();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra enviada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao enviar ordem de compra"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			for (OrdemCompra i : facade.listarOrdemCompra("")) {
				this.lista.add(i);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar ordens"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarOrdemCompra(ordem);
			if(retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra editada!"));
				listar();
			}
			this.ordem = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar ordem de compra"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirOrdemCompra(this.ordem);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra deletada"));
			this.ordem = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir ordem de compra"));
			e.printStackTrace();
		}
	}
	
	public void addItem() {
		PedidoCompra p = new PedidoCompra();
		p.setNome(selecionado.getNome());
		p.setMarca(selecionado.getMarca());
		this.ordem.getItem().add(p);
	}
	
	public void onRowEdit(RowEditEvent<OrdemCompra> event) {
		OrdemCompra novo = new OrdemCompra();

		for (OrdemCompra i : this.lista) {
			if (i.getId() == event.getObject().getId()) {
				novo = i;
			}
		}

		if (event.getObject() != null) {
			try {
				this.ordem = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<OrdemCompra> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public OrdemCompraController() {
		this.ordem = new OrdemCompra();
		this.lista = new ArrayList<OrdemCompra>();
		this.selecionado = new Item();
		listar();
	}
	public OrdemCompra getOrdem() {
		return ordem;
	}
	public void setOrdem(OrdemCompra ordem) {
		this.ordem = ordem;
	}
	public List<OrdemCompra> getLista() {
		return lista;
	}
	public void setLista(List<OrdemCompra> lista) {
		this.lista = lista;
	}

	public Item getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Item selecionado) {
		this.selecionado = selecionado;
	}


	
	
	
}
