package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Token;

//@Service
public abstract interface TokenWrapper {

	/**
	 * Disponibiliza o objeto Token os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return Token
	 * @author proitec-legacy
	 * @see Token
	 * @see WebClient
	 * @param client_credentials - portal developers BB
	 * @param scope              - portal developers BB
	 * @param bearer             - portal developers BB
	 */
	public abstract Token tokenObject(String client_credentials, String scope, String basic);

	/**
	 * Disponibiliza a String Token os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return String
	 * @author proitec-legacy
	 * @see Token
	 * @see WebClient
	 * @param client_credentials - portal developers BB
	 * @param scope              - portal developers BB
	 * @param bearer             - portal developers BB
	 */
	public abstract String tokenString(String client_credentials, String scope, String basic);
}