package br.com.bb.developers.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.exception.ErrorInternalException;
import br.com.bb.developers.exception.NotFoundException;
import br.com.bb.developers.model.Pix;
import br.com.bb.developers.service.PixWrapper;
import reactor.core.publisher.Mono;

/**
 * @author proitec-legacy 
 * @apiNote Classe com os parametros de configuração da cobrança de PIX
 * @see Pix
 */
@Service
public class PixService implements PixWrapper {

	@Override
	public Pix gerarPixObject(String bearer, Pix pix) {
		
        WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_COBRANCA);
		
		Mono<Pix> object = client.put()
				.uri(builder -> builder.path("/cob/")
				.queryParam("gw-dev-app-key","d27b577902ffabc01361e17db0050356b931a5ba")
				.build())
				.header("Authorization" ,bearer)
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.bodyValue(pix)
				//.body(BodyInserters.fromValue(null))
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException("Deu zica erro 404"));
	             })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException("Deu zica erro 500"));
	             })
				.bodyToMono(Pix.class);		
	
				Pix block = object.share().block();
				
		return block;	
	}

	@Override
	public Pix consultarPixObject(String bearer, String txid) {
		
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_CONSULTAR);
		
		Mono<Pix> object = client.get()
				.uri(builder -> builder.path("/cob/{:txid}")
				.queryParam("gw-dev-app-key","d27b577902ffabc01361e17db0050356b931a5ba")
			    .build(txid))
		        .header("Authorization" ,bearer)
		        .header("Content-Type", "application/json")
		        .accept(org.springframework.http.MediaType.APPLICATION_JSON)
		        .retrieve()
		        .onStatus(HttpStatus::is4xxClientError, response -> {
                     return Mono.error(new NotFoundException("Deu zica erro 404"));
                 })
		         .onStatus(HttpStatus::is5xxServerError, response -> {
                      return Mono.error(new ErrorInternalException("Deu zica erro 500"));
                 })
		         .bodyToMono(Pix.class);		

		         Pix block = object.share().block();
		
        return block;
	}
}