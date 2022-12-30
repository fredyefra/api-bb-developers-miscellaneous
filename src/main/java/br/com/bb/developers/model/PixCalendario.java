package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy Classe que 'representa' a data de criação e tempo de vida do Pix. 
 *         
 *         
 */
public class PixCalendario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String criacao;
	private Integer expiracao;

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public Integer getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(Integer expiracao) {
		this.expiracao = expiracao;
	}

	@Override
	public String toString() {
		return "PixCalendario [Data criação =" + criacao + ", Tempo expiracao=" + expiracao + "]";
	}
}

