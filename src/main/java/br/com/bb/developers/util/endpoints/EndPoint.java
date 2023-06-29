package br.com.bb.developers.util.endpoints;

/**
 * @author fredyefra 
 * @see Endpoints disponíveis no bb developers.
 */
public final class EndPoint {

	private EndPoint() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Constante para o fluxo authorization code "https://oauth.hm.bb.com.br/ui/authorize".
	 */
	public static final String ENDPOINT_AUTHORIZATION_CODE = "https://oauth.hm.bb.com.br";
	
	/**
	 * @see Constante para o fluxo client credentials "https://oauth.hm.bb.com.br/oauth/token".
	 */
	//public static final String ENDPOINT_CLIENT_CREDENTIALS = "https://oauth.hm.bb.com.br/oauth/token";
	public static final String ENDPOINT_CLIENT_CREDENTIALS = "https://oauth.hm.bb.com.br/oauth/token";
	
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

	/**
	 * @see Constante equivalente a "https://api.hm.bb.com.br/pix/v1/cob/".
	 */
	public static final String ENDPOINT_PIX_REVISAR = "https://api.hm.bb.com.br/pix/v1";

	/**
	 * @see Constante equivalente a "https://api.hm.bb.com.br".
	 */
	public static final String END_POINT_LOGIN_OAUTH = "https://api.hm.bb.com.br";

}