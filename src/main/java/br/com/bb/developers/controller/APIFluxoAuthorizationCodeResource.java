package br.com.bb.developers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.developers.service.FluxoAuthorizationCodeWrapper;
import br.com.bb.developers.service.TokenWrapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import reactor.core.publisher.Mono;


@Api(value = "fluxo-autorizacao-code", tags = "Endpoint para demonstrar o fluxo de autorização code.")
@RestController
@RequestMapping(value = "developers/bb/fluxo-auth-code/v1")
public class APIFluxoAuthorizationCodeResource {

	@Autowired
	private TokenWrapper token;
	
	@Autowired
	private FluxoAuthorizationCodeWrapper fluxoAuthCode;

	@GetMapping(value = "/fluxo-auth-code")
	public Mono<String> authCode(@RequestParam (required = true, name = "client_id")
	                                            @Parameter(example = "client_id", description = "client_id") final String client_id) 
	{

		return fluxoAuthCode.authorizationCodehString(client_id);
	}


	@PostMapping
	public ResponseEntity<String> gerarToken(@RequestHeader(required =true, name ="Authorization")
	                                         @Parameter(example = "Basic", description = "Basic") String basic,
	                                         @RequestBody   (required = true) String code)
	{
		String bearer = token.getAccessTokenTeste(code , basic);
		return ResponseEntity.ok().body(bearer);
	}

}