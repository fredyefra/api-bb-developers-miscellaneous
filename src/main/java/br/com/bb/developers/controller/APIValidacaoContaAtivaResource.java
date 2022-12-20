package br.com.bb.developers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.developers.model.ContaAtiva;
import br.com.bb.developers.service.TokenWrapper;
import br.com.bb.developers.service.impl.TokenService;

@RestController
@RequestMapping(value = "developers/bb/v1")
public class APIValidacaoContaAtivaResource {

	//@Autowired
	private TokenWrapper service = new TokenService();  

	@PostMapping
	public String gerarToken() {

		String bearer = service.tokenString("client_credentials", "validacao-contas.info",
				"Basic ");
		return bearer;
	}

	//@GetMapping(value = "/validacao-conta")
	public ResponseEntity<ContaAtiva> verificaContaAtiva() {

		return ResponseEntity.ok().body(null);
	}
}