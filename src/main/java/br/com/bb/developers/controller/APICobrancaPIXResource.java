package br.com.bb.developers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.developers.model.Pix;
import br.com.bb.developers.service.PixWrapper;
import br.com.bb.developers.service.TokenWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;

//@CrossOrigin("*") 
@Api(value = "pix-resource") 
@RestController
@RequestMapping(value = "developers/bb/cobranca-pix/v1")
@Hidden
public class APICobrancaPIXResource {

	@Autowired
	private TokenWrapper token;  
    
	@Autowired
	private PixWrapper pix;
	
	@ApiOperation(value = "Token de acesso deve ser informado nas requisições da API'S.")
	@PostMapping
	public ResponseEntity<String> gerarToken(@RequestHeader(required = true, name = "Authorization") String basic) {
		String bearer = token.tokenString("client_credentials", "cob.write cob.read pix.read pix.write", basic);
		return ResponseEntity.ok().body(bearer);
	}

	@ApiOperation(value = "Gerar cobrança PIX.")
    @PutMapping(value= "/gerar-cobranca-pix")
	public ResponseEntity<Pix> gerarCobranca(@RequestHeader(required = true, name = "Authorization") String bearer,
    @RequestBody Pix cobranca)
	{
		//PixValor valor = new PixValor();
		//valor.setOriginal("800.00");
		
		//cobranca = new Pix();
		//cobranca.setChave("testqrcode01@bb.com.br");
		//cobranca.setValor(valor);
		
		Pix pixObject = pix.pixObject(bearer, cobranca);
		//return ResponseEntity.ok().body(pixString);
		return new ResponseEntity<Pix>(pixObject, HttpStatus.CREATED);
	}
}