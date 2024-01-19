package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author fredyefra
 * Classe que 'representa' a conta ativa com as informações do ENDPOINT.
 */
public class ContaAtiva implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contaAtiva;
	private String titularConta;

	public ContaAtiva() {

	}

	public String getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(String contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	@Override
	public String toString() {
		return "ContaAtiva [contaAtiva=" + contaAtiva + ", titularConta=" + titularConta + "]";
	}

}