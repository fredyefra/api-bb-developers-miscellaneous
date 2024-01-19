package br.com.bb.developers.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import br.com.bb.developers.exception.ErrorInternalException;
import br.com.bb.developers.exception.NotFoundException;
import br.com.bb.developers.model.FluxoAuthorizationCode;
import br.com.bb.developers.model.Token;
import br.com.bb.developers.service.TokenWrapper;
import reactor.core.publisher.Mono;

/**
 * @author fredyefra
 * @apiNote Classe com os parametros de configuração do token.
 * @see Token
 */
@Service
public class TokenService implements TokenWrapper {

	@Override
	public Token tokenObject(String client_credentials, String scope, String basic) {

		WebClient client = WebClient.create();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", client_credentials);
		body.add("scope", scope);

		Mono<Token> request = client.post()
				.uri(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_CLIENT_CREDENTIALS)
				.header("Authorization", basic)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters
				.fromFormData(body))
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException(HttpStatus.NOT_FOUND.toString()));
	             })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
	             })
				.bodyToMono(Token.class);
				
                Token token = request.block(); 
		
		return token;
	}

	@Override
	public String tokenString(String client_credentials, String scope, String basic) {
		
		WebClient client = WebClient.create();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", client_credentials);
		body.add("scope", scope);

		Mono<Token> request = client.post()
				.uri(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_CLIENT_CREDENTIALS)
				. header("Authorization", basic)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters
				.fromFormData(body))
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException(HttpStatus.NOT_FOUND.toString()));
	             })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
	             })
				.bodyToMono(Token.class);

		String token = request.block().getAccess_token();

		return token;
	}

	// TODO Testar esse fluxo 
	@Override
	public Mono<String> getAccessTokenTeste(String code, String basic) {
		
		WebClient client = WebClient.create();
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("code", code);
		body.add("redirect_uri", "https://www.getpostman.com\"");
		
		Mono<String> request = client.post()
				.uri(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_CLIENT_CREDENTIALS)
				. header("Authorization", basic)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters
				.fromFormData(body))
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException(HttpStatus.NOT_FOUND.toString()));
	             })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
	             })
				.bodyToMono(String.class);

		request.log();

		
		
		return request;

	}
}