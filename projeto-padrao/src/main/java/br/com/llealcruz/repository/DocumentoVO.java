package br.com.llealcruz.repository;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.llealcruz.service.DocumentoService;

@Named
public class DocumentoVO {

	private String tipo;
	private BigDecimal credito;
	private BigDecimal debito;
	private BigDecimal movimento;
	private BigDecimal juros;
	private BigDecimal imposto;
	private String data;
	
	@Inject
	DocumentoService service;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat f = DateFormat.getDateInstance();

	public DocumentoVO(String tipo, BigDecimal credito, BigDecimal debito, BigDecimal movimento, BigDecimal juros, BigDecimal imposto, String data) {
		super();
		this.credito = credito;
		this.debito = debito;
		this.movimento = movimento;
		this.juros = juros;
		this.imposto = imposto;
		this.data = data;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public BigDecimal getDebito() {
		return debito;
	}

	public void setDebito(BigDecimal debito) {
		this.debito = debito;
	}

	public BigDecimal getMovimento() {
		return movimento;
	}

	public void setMovimento(BigDecimal movimento) {
		this.movimento = movimento;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getImposto() {
		return imposto;
	}

	public void setImposto(BigDecimal imposto) {
		this.imposto = imposto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
