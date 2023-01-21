package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Pix;

public interface PixWrapper {

	/**
	 * Disponibiliza o objeto cobrança Pix  os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return Pix
	 * @author proitec-legacy
	 * @see Pix
	 * @see WebClient
	 * @param bearer - portal developers BB
	 * @param Pix - portal developers BB
	 */
	public Pix gerarPixObject(String bearer, Pix pix);
	
	/**
	 * Disponibiliza o objeto consulta Pix  os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return Pix
	 * @author proitec-legacy
	 * @see Pix
	 * @see WebClient
	 * @param bearer - portal developers BB
	 * @param txId - portal developers BB
	 */
	public Pix consultarPixObject(String bearer, String txId);
	
}