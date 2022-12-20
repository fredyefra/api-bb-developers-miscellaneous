package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy
 * Token de acesso que deve ser informado nas requisições das APIs do BB.
 * Classe que 'representa' o token com as informações do ENDPOINT.
 */
public class Token implements Serializable {

	private static final long serialVersionUID = 1L;
	private String access_token;
	private String token_type;
	private Integer expires_in;
	private String scope;

	public Token() {

	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}