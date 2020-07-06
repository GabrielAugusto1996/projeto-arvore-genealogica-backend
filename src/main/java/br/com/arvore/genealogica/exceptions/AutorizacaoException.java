package br.com.arvore.genealogica.exceptions;

public class AutorizacaoException extends RuntimeException {

	public AutorizacaoException(String msg) {
		super(msg);
	}
	
	public AutorizacaoException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
