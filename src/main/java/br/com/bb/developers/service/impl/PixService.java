package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Pix;
import br.com.bb.developers.service.PixWrapper;

@Service
public class PixService implements PixWrapper {

	private static final String ENDPOINT = "https://api.hm.bb.com.br/pix/v1/cob/";
	
	@Override
	public Pix pixObject(String bearer, Pix pix) {
		
        WebClient client = WebClient.create("https://api.hm.bb.com.br/pix/v1");
		
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
		
        WebClient client = WebClient.create("https://api.hm.bb.com.br/pix/v1");
    	
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