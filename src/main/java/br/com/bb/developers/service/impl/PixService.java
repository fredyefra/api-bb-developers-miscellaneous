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
				.header("Authorization" , bearer)
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
		        .header("Authorization" , bearer)
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

	public static void main(String[] args) {
		System.out.println(new PixService().consultarPixObject("Bearer Pz8EryRwCIT2ufyKhnA5ZSXXy4RoTvvLi50J0Z3-pQVQgkEh9K3kcRy6Kdt5zZH-RJmPZHbx5wog2ejPS9omgw.fC5Gww9bMyG3i9JMCsXL7oNxXw7Yq3OA853BEMju3AIIj87yhzfCdzOKTkTpJqpjWU4CdofM9SJt0gD7blINrVl7eCWsf8cHXJJDfd2RPbnCFzWb5yHk3DWG21tS8RSrnZ89UMTGfXqX6JkoOLTxtTanQx1jICh7q0eeaOIrmMTJRbZ-ncZdzIfW4zyjNZW9wISQzkOd1IuvrQGde9GmwYkIwQTJu2GecB5c2zKiB13OGaZzkoxvPadsA9o1oaMYuu9OuxBcgLD1l-dMsSieSXk50PBcyRdKFNHnDvcDhHXhw3MywOq23yaHTI1g3BJQGz3j-N3wPeeHxyoJuF6mbvAMuRFNl0Rq0ndRyzxQtKISaBHXmVuEbWSMbJs74GWYbJP_edjT64SW9As6k4xh4aW-5tWImBOsJP53yurpu5k9ssqGWPU-BZ4xKrIzHfs3XGddQvpPDhRKwbb2CuGpxlUODrL6Hoadhei4lWAKlYl0qPJWoOSKgwb3DX1tGmduSdlwZEqKnzsHq9P067jd7gGnT7ONhSMKwbGlTbfBa83R3Rnu1RnFbgwwf6jGs1sOnUQWmKAjflevPHNubEFy1toqYAAcmnLUrd3hhfP7awpO727hExCbv0wp2l2LT_lGO7n_RvaDSl8_WBKrLFDXvcxTbZaJ4wdqZAEBnU9nmjMdyRxI_dBGrJMyBZN_OsLOSHkenu9n_z3E_hvzol5pHsKNFkBO9Y_4Ikivi-9-kFccPZBrUQKDyRAsEgL_hGQWP1ip2sJwkynzjKoN6fK25JriGEM6PdHb-TMjuwkeFqf89NlGH1zFyC8mxBqbZm84b_h9g0RtHqLNAsIC7E5PP2rmpEulEO0lTLsWw_Y9I5d0uS47xCbWcAqDnpg1AsfB_A1Do3BGGbbvVsrQfAHXnnfe2t5SMhxKTY_xIOXkJsh6Mv3eG5V_0-m2MWKEJGCeuZG3t_06P_7z6Bk7jVezIg0kn3lOt4uAZpkQgRXlvW4.B6jquJEyb8n0zeOjr_wxMpPAFFm1xibVcGAJlrsDn08s6wl2WYwfgAUNBrXV9uziAr5PnmrsGZi2A0WK9z0dyw", 
				"a47G7vMvU1byIz67fbwfMcF7FS986na5VdX"));
	}
	
}