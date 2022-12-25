package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy Classe que 'representa' a cobrança de pix com as
 *         informações do ENDPOINT.
 */
public class Pix implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private Calendario calendario;
	private String location;
	private String textoImagemQRcode;
	private String txid;
	private Integer revisao;
	private Devedor devedor;
	private Valor valor;
	private String chave;
	private String solicitacaoPagador;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTextoImagemQRcode() {
		return textoImagemQRcode;
	}

	public void setTextoImagemQRcode(String textoImagemQRcode) {
		this.textoImagemQRcode = textoImagemQRcode;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public Integer getRevisao() {
		return revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	public Devedor getDevedor() {
		return devedor;
	}

	public void setDevedor(Devedor devedor) {
		this.devedor = devedor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getSolicitacaoPagador() {
		return solicitacaoPagador;
	}

	public void setSolicitacaoPagador(String solicitacaoPagador) {
		this.solicitacaoPagador = solicitacaoPagador;
	}
}

class Calendario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String criacao;
	private String expiracao;

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}
}

class Devedor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

class Valor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String original;

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}
}