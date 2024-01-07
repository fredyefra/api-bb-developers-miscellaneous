package br.com.bb.developers.service.impl;

import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.FluxoAuthorizationCode;
import br.com.bb.developers.service.FluxoAuthorizationCodeWrapper;
import reactor.core.publisher.Mono;


/**
 * @author fredyefra
 * @apiNote Este fluxo se inicia com a aplicação direcionando 
 * o cliente para a Interface Gráfica do OAuth (Fluxo Auth Code) do BB.
 * @see FluxoAuthorizationCode
 */

@Service
public class FluxoAuthorizationCodeService implements FluxoAuthorizationCodeWrapper {

	@Override
	public Mono<FluxoAuthorizationCode> authorizationCodeObject(String client_id) {
		
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_AUTHORIZATION_CODE);
		
		return   client.get()
				.uri(builder -> builder.path("/ui/authorize")
				.queryParam("response_type", "code") //Informa ao servidor de autorização que o aplicativo está iniciando o fluxo \"Authorization Code\
				.queryParam("client_id", client_id) //Identificador do aplicativo, obtido quando o DEV registra o aplicativo pela primeira vez
				.queryParam("state", "123") //O aplicativo gera uma string aleatória e a inclui na solicitação. Em seguida, ele deve verificar se o mesmo valor é retornado depois que o usuário autoriza o aplicativo.
				.queryParam("scope", "openid-otp") // Cada recurso de uma API possui escopos próprios para autorização."
				.queryParam("redirect_uri", "https://www.getpostman.com") //A URL deve estar configurada na URI de callback.
				.build())
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(FluxoAuthorizationCode.class);
		
		//FluxoAuthorizationCode response = request.share().block();
		
		//return response;
	}

	@Override
	public Mono<String> authorizationCodehString(String client_id) {
    
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_AUTHORIZATION_CODE);
		
		return   client.get()
				.uri(builder -> builder.path("/ui/authorize")
				.queryParam("response_type", "code")
				.queryParam("client_id", decodeClientId(client_id))
				.queryParam("state", "123")
				.queryParam("scope", "openid-otp")
				.queryParam("redirect_uri", "https://www.getpostman.com")
				.build())
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED)
				.retrieve()
				.bodyToMono(String.class);
				
		//return request;

	}

	private String decodeClientId(String clientId) {
		return Base64.getEncoder().encodeToString(clientId.getBytes());
	}
}