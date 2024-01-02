package br.com.bb.developers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.developers.model.ContaAtiva;
import br.com.bb.developers.service.ContaAtivaWrapper;
import br.com.bb.developers.service.TokenWrapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;

@Api(value = "conta-ativa-resource", tags = "Endpoint destinado a consultar uma conta ativa.")
@RestController
@RequestMapping(value = "developers/bb/conta-ativa/v1")
public class APIValidacaoContaAtivaResource {

	@Autowired
	private TokenWrapper token;  

	@Autowired
	private ContaAtivaWrapper conta;
	
	@PostMapping
	public ResponseEntity<String> gerarToken(
			//@RequestHeader(required = true, name ="Authorization") String basic) 
			@RequestHeader(required =true, name ="Authorization")@Parameter(example = "Basic", description = "Basic") String basic)
	{
		String bearer = token.tokenString("client_credentials", "validacao-contas.info", basic);
		return ResponseEntity.ok().body(bearer);
	}

	@GetMapping(value = "/validacao-conta")
	public ResponseEntity<ContaAtiva> verificaContaAtiva(
			//@RequestHeader(required = true, name = "Authorization") String bearer,
			@RequestHeader(name ="Authorization")@Parameter(example = "Bearer", description = "Bearer") String bearer, 
			@RequestParam  (required = true, name = "gw-dev-app-key")  String gw_dev_app_key) 
	{
        ContaAtiva contaAtiva = conta.contaAtivaObject(bearer, gw_dev_app_key);  
        return ResponseEntity.ok().body(contaAtiva);
	}
}