package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.FluxoAuthorizationCode;
import br.com.bb.developers.service.FluxoAuthorizationCodeWrapper;
import reactor.core.publisher.Mono;


/**
 * @author fredyefra
 * @apiNote Este fluxo se inicia com a aplicação direcionando 
 * o cliente para a Interface Gráfica do OAuth do Banco do Brasil.
 * @see FluxoAuthorizationCode
 */

@Service
public class FluxoAuthorizationCodeService implements FluxoAuthorizationCodeWrapper {

	@Override
	public FluxoAuthorizationCode authorizationCodeObject() {
		
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_AUTHORIZATION_CODE);
		
		//String response_type, String client_id, String redirect_uri, String scope, String state
		
		MultiValueMap<String, String> pathParam = new LinkedMultiValueMap<>();
		pathParam.add("response_type", "code");
		pathParam.add("client_id", "");
		pathParam.add("redirect_uri", "https://www.getpostman.com");
		pathParam.add("scope", "openid-otp");
		pathParam.add("state", "123");
		
		Mono<FluxoAuthorizationCode> request = client.get()
				.uri(builder -> builder.path("/ui/authorize")
				.queryParams(pathParam)
				.build())
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(FluxoAuthorizationCode.class);
				
		FluxoAuthorizationCode response = request.share().block();
		
		return response;
	}

	@Override
	public FluxoAuthorizationCode authorizationCodehObject2(FluxoAuthorizationCode fluxoAuthorizationCode) {
		// TODO Auto-generated method stub
		return null;
	}
}