package br.com.llealcruz.view;

import java.io.Serializable;
import java.math.BigDecimal;
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

	@Inject
	DocumentoService service;

	private List<DocumentoVO> documentos = new ArrayList<>();
	private BigDecimal totalDeDebitos;

	public List<DocumentoVO> getDocumentos() {
		documentos = service.criaDocumentos();
		return documentos;
	}

	public void setDocumentos(List<DocumentoVO> documentos) {
		this.documentos = documentos;
	}
	
	public BigDecimal getTotalDeDebitos() {
		totalDeDebitos = service.calculaTotalDebito();
		return totalDeDebitos;
	}

	public void setTotalDeDebitos(BigDecimal totalDeDebitos) {
		this.totalDeDebitos = totalDeDebitos;
	}
}
