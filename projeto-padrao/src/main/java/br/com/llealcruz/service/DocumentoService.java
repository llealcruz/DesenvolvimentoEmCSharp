package br.com.llealcruz.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.llealcruz.repository.DocumentoVO;

@Named
@ApplicationScoped
public class DocumentoService {

	public List<DocumentoVO> criaDocumentos() {
		List<DocumentoVO> listaDeDocumentos = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {
			BigDecimal valorAleatorio = formatarBigDecimal(2, new BigDecimal(Math.random() * 100000));
			String dataAleatoria = formatarData(new Date(ThreadLocalRandom.current().nextInt() * 1000L)); 
			DocumentoVO documento = new DocumentoVO(valorAleatorio, valorAleatorio, valorAleatorio, valorAleatorio,
					valorAleatorio, dataAleatoria);
			listaDeDocumentos.add(i, documento);
		}
		return listaDeDocumentos;
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
}
