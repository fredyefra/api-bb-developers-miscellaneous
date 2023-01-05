package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Pix;
import br.com.bb.developers.service.PixWrapper;

/**
 * @author proitec-legacy 
 * @apiNote Classe com os parametros de configuração da cobrança de PIX
 * @see Pix
 */
@Service
public class PixService implements PixWrapper {

	@Override
	public Pix pixObject(String bearer, Pix pix) {
		
        WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_COBRANCA);
		
		Pix object = client.put()
				.uri(builder -> builder.path("/cob/")
				.queryParam("gw-dev-app-key","d27b577902ffabc01361e17db0050356b931a5ba")
				.build())
				.header("Authorization" , bearer)
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.bodyValue(pix)
				//.body(BodyInserters.fromValue(null))
				.retrieve()
				.bodyToMono(Pix.class)
				.block();
	
		return object;	
	}

	@Override
	public String pixString(String bearer, Pix pix) {
		
        WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_COBRANCA);
		
		String string = client.put()
				.uri(builder -> builder.path("/cob/")
				.queryParam("gw-dev-app-key","d27b577902ffabc01361e17db0050356b931a5ba")
				.build())
				.header("Authorization" , bearer)
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.bodyValue(pix)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		return string;	
	}
}