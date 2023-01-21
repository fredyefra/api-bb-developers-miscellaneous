package br.com.bb.developers.util.endpoints;

/**
 * @author proitec-legacy 
 * @see Endpoints disponíveis no bb developers.
 */
public final class EndPoint {

	private EndPoint() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Constante equivalente a "https://oauth.hm.bb.com.br/oauth/token".
	 */
	public static final String ENDPOINT_TOKEN = "https://oauth.hm.bb.com.br/oauth/token";

	/**
	 * @see Constante equivalente a "https://api.hm.bb.com.br/validacao-contas/v1".
	 */
	public static final String ENDPOINT_CONTA_ATIVA = "https://api.hm.bb.com.br/validacao-contas/v1";

	/**
	 * @see Constante equivalente a "https://api.hm.bb.com.br/pix/v1/cob/".
	 */
	public static final String ENDPOINT_PIX_COBRANCA = "https://api.hm.bb.com.br/pix/v1";

	/**
	 * @see Constante equivalente a "https://api.hm.bb.com.br/pix/v1/cob/".
	 */
	public static final String ENDPOINT_PIX_CONSULTAR = "https://api.hm.bb.com.br/pix/v1";

}
