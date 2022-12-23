package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Token;
import br.com.bb.developers.service.TokenWrapper;

/**
 * @author proitec-legacy
 * Classe com os parametros de configuração do token.
 */

@Service
public class TokenService implements TokenWrapper {

	private static final String ENDPOINT = "https://oauth.hm.bb.com.br/oauth/token";

	@Override
	public Token tokenObject(String client_credentials, String scope, String basic) {

		WebClient client = WebClient.create();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", client_credentials);
		body.add("scope", scope);
		// body.add("grant_type", "client_credentials");
		// body.add("scope", "cob.write cob.read pix.read pix.write");

		Token object = client.post()
				.uri(ENDPOINT)
				.header("Authorization",basic)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromFormData(body))
				.retrieve()
				.bodyToMono(Token.class)
				.block();

		return object;
	}

	@Override
	public String tokenString(String client_credentials, String scope, String basic) {
		
		WebClient client = WebClient.create();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", client_credentials);
		body.add("scope", scope);

		Token token = client.post()
				.uri(ENDPOINT)
				. header("Authorization", basic)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters
				.fromFormData(body))
				.retrieve()
				.bodyToMono(Token.class)
				.block();

		String tokenAccess = token.getAccess_token();

		return tokenAccess;
	}
}