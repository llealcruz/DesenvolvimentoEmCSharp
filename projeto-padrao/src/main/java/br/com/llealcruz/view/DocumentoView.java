package br.com.llealcruz.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.llealcruz.repository.DocumentoVO;
import br.com.llealcruz.service.DocumentoService;

@Named
@ViewScoped
public class DocumentoView implements Serializable {
		private static final long serialVersionUID = -6909015239058253375L;

	public DocumentoView() {
		
	}

	
	@Inject
	DocumentoService service;
	
	List<DocumentoVO> ListaDeDocumentos = new ArrayList<DocumentoVO>();
	
	public List<DocumentoVO> GerarTabelaDeDocumentos(){
		return service.criaDocumentos();
	}
}
