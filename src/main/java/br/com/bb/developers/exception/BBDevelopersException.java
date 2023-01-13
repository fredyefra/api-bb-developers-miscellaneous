package br.com.bb.developers.exception;

/**
 * @author proitec
 * @see Classe responsavel por montar o campos de erro.
 */
public class BBDevelopersException {

	// {
	// "timestamp": 1673479422101,
	// "status": 404,
	// "error": "Not Found",
	// "message": "No message available",
	// "path": "/developers/bb/cob-pix/v1/gerar-cobrancax-pix"
	// }

	private Long timeStamp;
	private Integer status;
	private String message;
	private String path;

	public BBDevelopersException(Long timeStamp, Integer status, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}

	public BBDevelopersException(Long timeStamp, Integer status, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}
}