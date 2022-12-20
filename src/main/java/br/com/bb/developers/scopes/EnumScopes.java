package br.com.bb.developers.scopes;

/**
 * @author proitec-legacy
 * Enum's para representar os escopes de cada ENDPOINT.
 */
public enum EnumScopes {

	ESCOPO_CONTA_ATIVA("validacao-contas.info"), 
	ESCOPO_COBRANCA_PIX("cob.write cob.read pix.read pix.write");

	private String escopo;

	EnumScopes(String escopo) {
		this.escopo = escopo;
	}

	public String getEscopo() {
		return escopo;
	}
}
