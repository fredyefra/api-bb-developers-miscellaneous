package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.ContaAtiva;
/**
 * @author proitec-legacy
 * */
public abstract interface ContaAtivaWrapper {

	/**
	 * Disponibiliza o objeto ContaAtiva os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return ContaAtiva
	 * @see ContaAtiva
	 * @see WebClient
	 * @param bearer - portal developers BB
	 * @param gw_dev_app_key - portal developers BB
	 */
	public abstract ContaAtiva contaAtivaObject(String bearer, String gw_dev_app_key);
}