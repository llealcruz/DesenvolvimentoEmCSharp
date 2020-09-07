package br.com.llealcruz.bean;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import java.io.Serializable;

@ManagedBean
@Named
@SessionScoped
public class TemaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, String> temas;
	private String tema;

	@PostConstruct
	public void init() {
		temas = new TreeMap<String, String>();
		temas.put("Aristo", "aristo");
		temas.put("Bluesky", "bluesky");
		temas.put("Cupertino", "cupertino");
		temas.put("Sam", "sam");
		temas.put("UI-Lightness", "ui-lightness");
		temas.put("Blitzer", "blitzer");
		tema = "blitzer";
	}

	public Map<String, String> getTemas() {
		return temas;
	}

	public void setTemas(Map<String, String> temas) {
		this.temas = temas;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
