package br.com.bb.developers.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.exception.ErrorInternalException;
import br.com.bb.developers.exception.NotFoundException;
import br.com.bb.developers.model.ContaAtiva;
import br.com.bb.developers.service.ContaAtivaWrapper;
import reactor.core.publisher.Mono;

/**
 * @author proitec-legacy
 * @apiNote Classe com os parametros de configuração da conta-ativa.
 * @see ContaAtiva
 */
@Service
public class ContaAtivaService implements ContaAtivaWrapper {

	@Override
	public ContaAtiva contaAtivaObject(String bearer, String gw_dev_app_key) {
		
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_CONTA_ATIVA);
		
		ContaAtiva object = client.get()
				.uri(builder -> builder.path("/contas/0551-1000/situacao")
				.queryParam("gw-app-key", gw_dev_app_key)
				.queryParam("cpfCnpj", "5887148012")
				.build())
				.header("Authorization" , bearer)
				.header("Content-Type", "application/json")
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException("Deu zica erro 404"));
	             })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException("Deu zica erro 500"));
	             })
				.bodyToMono(ContaAtiva.class)
				.block();
	
		return object;
	}
}