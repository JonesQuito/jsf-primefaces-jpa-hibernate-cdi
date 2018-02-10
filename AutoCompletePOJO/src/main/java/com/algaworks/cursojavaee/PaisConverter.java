package com.algaworks.cursojavaee;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("paisConverter")
public class PaisConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integer codigo = null;
		if(value != null) {
			System.out.println("getAsObject: " + value);
			
			try {
				codigo = new Integer(value);
			}catch (NumberFormatException e) {	}
			
			for(Pais pais : PerfilUsuarioBean.PAISES) {
				if(codigo.equals(pais.getCodigo())) {
					return pais;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null && !value.equals("")) {
			return ((Pais)value).getCodigo().toString();
		}
		return null;
	}

}
