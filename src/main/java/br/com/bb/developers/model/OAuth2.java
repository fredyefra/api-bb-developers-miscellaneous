package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy
 * @see OAuth2 representa o protocolo de autorização que permite o acesso limitado a contas de usuários 
 * em um serviço HTTP sem a necessidade de enviar usuário/senha.
 */

public class OAuth2 implements Serializable {
    
	private static final long serialVersionUID = 1L;
    private String response_type;
    private String client_id;	
    private String redirect_uri;
    private String scope;
    private String state;
    
    public OAuth2() {
	
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