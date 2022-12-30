package br.com.bb.developers.model;

import java.io.Serializable;


/**
 * @author proitec-legacy 
 * @see Classe que 'representa' o devedor do Pix que é direcionado. 
 *                  
 */
public class PixDevedor implements Serializable {
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

	@Override
	public String toString() {
		return "PixDevedor [Cpf do devedor =" + cpf + ", Nome do devedor=" + nome + "]";
	}

}