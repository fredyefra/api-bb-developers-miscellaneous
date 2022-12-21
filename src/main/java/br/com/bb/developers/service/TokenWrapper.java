package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Token;

public abstract class TokenWrapper {

	/**
	 * Disponibiliza o objeto Token os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return Token
	 * @author proitec-legacy
	 * @see Token
	 * @see WebClient
	 * @param client_credentials - developers BB
	 * @param scope              - developers BB
	 * @param bearer
	 */
	public abstract Token tokenObject(String client_credentials, String scope, String bearer);

	/**
	 * Disponibiliza a String Token os parametros e credencias estão disponiveis no portal
	 * developers bb.
	 * @return String
	 * @author proitec-legacy
	 * @see Token
	 * @see WebClient
	 * @param client_credentials - developers BB
	 * @param scope
	 * @param bearer
	 */
	public abstract String tokenString(String client_credentials, String scope, String bearer);
}