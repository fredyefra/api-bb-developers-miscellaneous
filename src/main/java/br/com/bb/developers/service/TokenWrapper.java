package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.FluxoAuthorizationCode;
import br.com.bb.developers.model.Token;
import reactor.core.publisher.Mono;

public interface TokenWrapper {

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
	public Token tokenObject(String client_credentials, String scope, String basic);

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
	public String tokenString(String client_credentials, String scope, String basic);


	
	//public FluxoAuthorizationCode  getAccessToken(String authorization_code, String code, String redirect_uri, String basic);

	//public String  getAccessTokenTeste(String authorization_code, String code, String redirect_uri, String basic);
	
	public Mono<String>  getAccessTokenTeste(String code, String basic);
	

}