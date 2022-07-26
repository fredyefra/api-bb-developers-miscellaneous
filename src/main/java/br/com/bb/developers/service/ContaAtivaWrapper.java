package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.ContaAtiva;

public abstract class ContaAtivaWrapper {

	/**
	 * Disponibiliza o objeto ContaAtiva os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return ContaAtiva
	 * @author proitec-legacy
	 * @see ContaAtiva
	 * @see WebClient
	 * @param client_credentials - developers BB
	 * @param scope
	 * @param bearer
	 */
	public abstract ContaAtiva contaAtivaObject(String bearer);
}