package br.com.arvore.genealogica.exceptions.usuario;

import br.com.arvore.genealogica.exceptions.NegocioException;

public class UsuarioExistenteException extends NegocioException {

	public UsuarioExistenteException(String msg) {
		super(msg);
	}

}
