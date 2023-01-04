package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.bb.developers.model.ContaAtiva;
import br.com.bb.developers.service.ContaAtivaWrapper;

/**
 * @author proitec-legacy
 * @apiNote Classe com os parametros de configuração da conta-ativa.
 * @see ContaAtiva
 */
@Service
public class ContaAtivaService implements ContaAtivaWrapper {

	//private static final String ENDPOINT = "https://api.hm.bb.com.br/validacao-contas/v1";

	@Override
	public ContaAtiva contaAtivaObject(String bearer) {
		
		WebClient client = WebClient.create(br.com.bb.developers.util.endpoint.EndPoint.ENDPOINT_CONTA_ATIVA);
		
		ContaAtiva object = client.get()
				.uri(builder -> builder.path("/contas/0551-1000/situacao")
				.queryParam("gw-app-key", "d27ba77903ffabc01361e17dc0050e56b941a5be")
				.queryParam("cpfCnpj", "5887148012")
				.build())
				.header("Authorization" , bearer)
				.header("Content-Type", "application/json")
				.retrieve()
				.bodyToMono(ContaAtiva.class)
				.block();
	
		return object;
	}
}