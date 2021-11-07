package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Produto;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraBean")
@ApplicationScoped
public class OrdemCompraController {
	
	private Requisicao ordem;
	private List<Requisicao> lista;
	private Produto selecionado;
	private List<RequisicaoItem> selectItens;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
				
		try {
			facade.salvarOrdemCompra(ordem);
			this.ordem = new Requisicao();
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
			this.lista = facade.listarOrdemCompra("");
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
			this.ordem = new Requisicao();
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
			this.ordem = new Requisicao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir ordem de compra"));
			e.printStackTrace();
		}
	}
	
	public void listarItens() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			this.selectItens = facade.listarOrdemCompraItem(this.ordem.getId());
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Itens listados!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar itens da compra"));
			e.printStackTrace();
		}
	}
	
	public void addItem() {
		RequisicaoItem p = new RequisicaoItem();
		p.setNome(selecionado.getNome());
		p.setMarca(selecionado.getMarca());
		this.ordem.getItem().add(p);
	}
	
	public void onRowEdit(RowEditEvent<Requisicao> event) {
		Requisicao novo = new Requisicao();

		for (Requisicao i : this.lista) {
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

	public void onRowCancel(RowEditEvent<Requisicao> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public OrdemCompraController() {
		this.ordem = new Requisicao();
		this.lista = new ArrayList<Requisicao>();
		this.selecionado = new Produto();
		this.selectItens = new ArrayList<RequisicaoItem>();
		listar();
	}
	public Requisicao getOrdem() {
		return ordem;
	}
	public void setOrdem(Requisicao ordem) {
		this.ordem = ordem;
	}
	public List<Requisicao> getLista() {
		return lista;
	}
	public void setLista(List<Requisicao> lista) {
		this.lista = lista;
	}

	public Produto getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Produto selecionado) {
		this.selecionado = selecionado;
	}

	public List<RequisicaoItem> getSelectItens() {
		return selectItens;
	}

	public void setSelectItens(List<RequisicaoItem> selectItens) {
		this.selectItens = selectItens;
	}


	
	
	
}
