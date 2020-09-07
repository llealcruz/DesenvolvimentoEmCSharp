package br.com.llealcruz.repository;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Named;

@Named
public class DocumentoVO {

	private BigDecimal credito;
	private BigDecimal debito;
	private BigDecimal movimento;
	private BigDecimal juros;
	private BigDecimal imposto;
	private Date data;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat f = DateFormat.getDateInstance();

	public DocumentoVO(BigDecimal credito, BigDecimal debito, BigDecimal movimento, BigDecimal juros, BigDecimal imposto, Date data) {
		super();
		this.credito = credito;
		this.debito = debito;
		this.movimento = movimento;
		this.juros = juros;
		this.imposto = imposto;
		this.data = data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
