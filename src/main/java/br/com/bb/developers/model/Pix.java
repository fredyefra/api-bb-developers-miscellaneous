package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy 
 * @see Classe que 'representa' a cobrança de pix com as
 *         informações do ENDPOINT.
 */
public class Pix implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private PixCalendario calendario;
	private String location;
	private String textoImagemQRcode;
	private String txid;
	private Integer revisao;
	private PixDevedor devedor;
	private PixValor valor;
	private String chave;
	private String solicitacaoPagador;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PixCalendario getCalendario() {
		return calendario;
	}

	public void setCalendario(PixCalendario calendario) {
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

	public PixDevedor getDevedor() {
		return devedor;
	}

	public void setDevedor(PixDevedor devedor) {
		this.devedor = devedor;
	}

	public PixValor getValor() {
		return valor;
	}

	public void setValor(PixValor valor) {
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

	@Override
	public String toString() {
		return "Pix [status=" + status + ", calendario=" + calendario + ", location=" + location
				+ ", textoImagemQRcode=" + textoImagemQRcode + ", txid=" + txid + ", revisao=" + revisao + ", devedor="
				+ devedor + ", valor=" + valor + ", chave=" + chave + ", solicitacaoPagador=" + solicitacaoPagador
				+ "]";
	}
}

  

