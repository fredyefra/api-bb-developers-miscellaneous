package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.OAuth2;

/**
 * @author proitec-legacy
 * */
public interface OAuth2Wrapper {

	/**
	 * Disponibiliza o objeto {@link OAuth2} 
	 * developers bb.
	 * @return {@link OAuth2}
	 * @author proitec-legacy
	 * @see OAuth2
	 * @see WebClient
	 * @param response_type - portal developers BB
	 * @param client_id     - portal developers BB
	 * @param redirect_uri         - portal developers BB
	 * @param scope         - portal developers BB
	 * @param state         - portal developers BB
	 */
	public abstract OAuth2 oauthObject(String response_type, String client_id, String redirect_uri, String scope, String state);
	
	
	public abstract OAuth2 oauthObject2(OAuth2 oAuth2);
	
	
	
}
