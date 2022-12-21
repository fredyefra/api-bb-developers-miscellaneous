package br.com.bb.developers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.developers.model.ContaAtiva;
import br.com.bb.developers.service.ContaAtivaWrapper;
import br.com.bb.developers.service.TokenWrapper;
import br.com.bb.developers.service.impl.ContaAtivaService;
import br.com.bb.developers.service.impl.TokenService;

@RestController
@RequestMapping(value = "developers/bb/v1")
public class APIValidacaoContaAtivaResource {

	//@Autowired 
	private TokenWrapper service = new TokenService();  

	//@Autowired
	private ContaAtivaWrapper conta = new ContaAtivaService();
	
	@PostMapping
	public String gerarToken(@RequestHeader(required = true, name = "Authorization") String basic) {
		String bearer = service.tokenString("client_credentials", "validacao-contas.info", basic);
		return bearer;
	}

	@GetMapping(value = "/validacao-conta")
	public ResponseEntity<ContaAtiva> verificaContaAtiva(@RequestHeader(required = true, name = "Authorization") String bearer) {
        ContaAtiva contaAtiva = conta.contaAtivaObject(bearer);  
		return ResponseEntity.ok().body(contaAtiva);
	}
}