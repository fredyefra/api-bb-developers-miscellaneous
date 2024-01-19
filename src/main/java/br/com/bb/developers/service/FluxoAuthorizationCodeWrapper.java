package br.com.bb.developers.service;

import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.FluxoAuthorizationCode;
import reactor.core.publisher.Mono;

/**
 * @author fredyefra
 * */
public interface FluxoAuthorizationCodeWrapper {

	/**
	 * Disponibiliza o objeto {@link FluxoAuthorizationCode} 
	 * developers bb.
	 * @return {@link FluxoAuthorizationCode}
	 * @author fredyefra
	 * @see FluxoAuthorizationCode
	 * @see WebClient
	 * @param response_type - portal developers BB
	 * @param client_id     - portal developers BB
	 * @param redirect_uri         - portal developers BB
	 * @param scope         - portal developers BB
	 * @param state         - portal developers BB
	 */
	public Mono<FluxoAuthorizationCode> authorizationCodeObject(String client_id);
	
	public Mono<String> authorizationCodehString(String client_id);
	
 
}