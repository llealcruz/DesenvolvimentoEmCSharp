package br.com.llealcruz.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.llealcruz.repository.DocumentoVO;
import br.com.llealcruz.view.DocumentoView;

@Named
@ApplicationScoped
public class DocumentoService {
	
	@Inject
	DocumentoView documentoView;
	
	private BigDecimal totalDebito = BigDecimal.ZERO;
	
	public BigDecimal calculaTotalDebito() {
		for (DocumentoVO documentoVO : documentoView.getDocumentos()) {
			totalDebito =  totalDebito.add(documentoVO.getDebito());
		}
		return totalDebito;
	}
	
	public List<DocumentoVO> criaDocumentos() {
		List<DocumentoVO> listaDeDocumentos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			BigDecimal valorAleatorio = formatarBigDecimal(2, new BigDecimal(Math.random() * 100000));
			String dataAleatoria = formatarData(new Date(ThreadLocalRandom.current().nextInt() * 1000L));
			String tipoAleatorio = gerarTipoAleatorio();
			DocumentoVO documento = new DocumentoVO(tipoAleatorio, valorAleatorio, valorAleatorio, valorAleatorio,
					valorAleatorio, valorAleatorio, dataAleatoria);
			listaDeDocumentos.add(i, documento);
		}
		return listaDeDocumentos;
	}

	public String gerarTipoAleatorio() {
		String[] tipos = { "TED", "DOC", "PIX" };
		String selecionado = tipos[new Random().nextInt(tipos.length)];
		return selecionado;
	}

	public String formatarData(Date data) {
		SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
		fd.format(data);
		String str = fd.format(data);
		return str;
	}

	private BigDecimal formatarBigDecimal(int casas, BigDecimal valor) {
		String quantCasas = "%." + casas + "f", textoValor = "0";
		try {
			textoValor = String.format(Locale.getDefault(), quantCasas, valor);
			if (textoValor.equals("Digits < 0"))
				textoValor = "0";
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return new BigDecimal(textoValor.replace(",", "."));
	}

	public BigDecimal getTotalDebito() {
		return totalDebito;
	}

	public void setTotalDebito(BigDecimal totalDebito) {
		this.totalDebito = totalDebito;
	}
}
