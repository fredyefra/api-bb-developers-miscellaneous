package br.com.bb.developers.model;

import java.io.Serializable;

/**
 * @author proitec-legacy 
 * @see Classe que representa o valor original de cobrança do Pix. 
 *                  
 */
public class PixValor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String original;

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	@Override
	public String toString() {
		return "PixValor [Valor original cobrança =" + original + "]";
	}
}