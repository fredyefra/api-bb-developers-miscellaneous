package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.Pix;
import br.com.bb.developers.service.PixWrapper;

@Service
public class PixService implements PixWrapper {

	private static final String ENDPOINT = "https://api.hm.bb.com.br/pix/v1/cob/";
 
	//https://api.hm.bb.com.br/pix/v1/cob/?gw-dev-app-key=d27b677900ffab30136ee17df0050e56b9c1a5b4
	
	@Override
	public Pix pixObject(String bearer) {
		
        WebClient client = WebClient.create(ENDPOINT);
        
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("calendario.expiracao", "3600");
		body.add("devedor.cpf", "12345678909");
		body.add("devedor.nome", "Francisco da Silva");
		body.add("valor.original", "123.45");
		body.add("chave", "testqrcode01@bb.com.br");
		body.add("solicitacaoPagador", "Cobrança dos serviços prestados.");
		
		Pix object = client.put()
				.uri(builder -> builder.path("")
				.queryParam("gw-app-key", "d27b677900ffab30136ee17df0050e56b9c1a5b4")
				.build())
				.header("Authorization" , bearer)
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromFormData(body))
				.retrieve()
				.bodyToMono(Pix.class)
				.block();
	
		return object;	
		
	}
}