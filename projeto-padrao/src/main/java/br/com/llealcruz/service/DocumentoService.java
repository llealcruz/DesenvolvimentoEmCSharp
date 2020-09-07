package br.com.llealcruz.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.llealcruz.repository.DocumentoVO;

@Named
@ApplicationScoped
public class DocumentoService {

	public List<DocumentoVO> criaDocumentos() {
		List<DocumentoVO> listaDeDocumentos = new ArrayList<>();
		BigDecimal numeroAleatorio = new BigDecimal(Math.random() * 100000);
		Date dataAleatoria = new Date(ThreadLocalRandom.current().nextInt() * 1000L);

		for (int i = 0; i <= 10; i++) {
			DocumentoVO documento = new DocumentoVO(numeroAleatorio, numeroAleatorio, 
					numeroAleatorio, numeroAleatorio,
					numeroAleatorio, dataAleatoria);
			listaDeDocumentos.add(i, documento);
		}
		return listaDeDocumentos;
	}
}
