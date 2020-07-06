package br.com.arvore.genealogica.exceptions;

public class NegocioException extends RuntimeException {

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Throwable e) {
        super(msg, e);
    }
}
