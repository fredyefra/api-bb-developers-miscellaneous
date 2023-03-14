package br.com.bb.developers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//@CrossOrigin("*") 
@Api(value = "pix-resource", tags = "Endpoints destinados a cobrança de PIX.")
@RestController
@RequestMapping(value = "developers/bb/cob-pix/v1")
public class APICobrancaPIXResource {

	@Autowired
	private TokenWrapper token;

	@Autowired
	private PixWrapper pix;

	@ApiOperation(value = "Gera o Token de acesso.")
	@PostMapping(value = "/gerar-token")
	public ResponseEntity<String> gerarToken(@RequestHeader(required = true, name = "Authorization") String basic) {
		
		String bearer = token.tokenString("client_credentials", "cob.write cob.read pix.read pix.write", basic);
		return ResponseEntity.ok().body(bearer);
	}

	@ApiOperation(value = "Gera a cobrança PIX.")
	@PutMapping(value = "/gerar-cobranca-pix")
	public ResponseEntity<Pix> gerarCobranca(@RequestHeader(required = true, name = "Authorization") String bearer,
			@RequestBody Pix cobranca) {
		
		return new ResponseEntity<Pix>(pix.gerarPixObject(bearer, cobranca), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Consulta a cobrança PIX.")
	@GetMapping(value = "/consultar-cobranca-pix/{txid}")
	public ResponseEntity<Pix> consultarCobranca(@RequestHeader(required = true, name = "Authorization") String bearer,
			@PathVariable String txid) {

		return new ResponseEntity<Pix>(pix.consultarPixObject(bearer, txid), HttpStatus.OK);

	}
}