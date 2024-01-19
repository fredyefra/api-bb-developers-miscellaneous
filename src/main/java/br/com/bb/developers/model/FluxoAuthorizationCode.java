package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author fredyefra
 * @see FluxoAuthorizationCode: Fluxo de autorização do OAuth requer alem da identificação da aplicação, 
 * a expressa autorização de um usuário (terceiro). Este fluxo se inicia com a aplicação direcionando 
 * o cliente para a Interface Gráfica do OAuth do Banco do Brasil 
 * em um serviço HTTP sem a necessidade de enviar usuário/senha.
 */

public class FluxoAuthorizationCode implements Serializable {
    
	private static final long serialVersionUID = 1L;
    String id_token;
    
    public String getId_token() {
		return id_token;
	}
    
    
    public FluxoAuthorizationCode() {
	
	}

	
}