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
    private String response_type;
    private String client_id;	
    private String redirect_uri;
    private String scope;
    private String state;
    
    public FluxoAuthorizationCode() {
	
	}

	public String getResponse_type() {
		return response_type;
	}


	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}


	public String getClient_id() {
		return client_id;
	}


	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}


	public String getRedirect_uri() {
		return redirect_uri;
	}


	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
}