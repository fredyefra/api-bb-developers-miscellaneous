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
	public Pix consultarPixObject(String bearer, String txid);
	
	/**
	 * Disponibiliza o objeto revisa Pix  os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return Pix
	 * @author proitec-legacy
	 * @see Pix
	 * @see WebClient
	 * @param bearer - portal developers BB
	 * @param txId - portal developers BB
	 * @param status - Status da cobrança disponível em https://apoio.developers.bb.com.br/referency/post/5fe221e7156f4c0012e4e2b2
	 */
	public Pix revisarPixObject(String bearer, String txid, String status);
	
}