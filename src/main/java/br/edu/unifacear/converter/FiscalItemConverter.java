package br.edu.unifacear.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.entity.FiscalItem;

@FacesConverter(forClass = FiscalItem.class)
public class FiscalItemConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if(codigo != null && !codigo.isEmpty()) {
			try {
				return (FiscalItem) new FiscalItemBo().listar(codigo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if(objeto != null) {
			FiscalItem f = (FiscalItem) objeto;
			if (f.getId() > 0) {
				return f.getNcm();
			}				
		}
		return null;
	}
	
}
