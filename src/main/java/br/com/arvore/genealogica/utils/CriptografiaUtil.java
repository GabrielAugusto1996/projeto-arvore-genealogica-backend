package br.com.arvore.genealogica.utils;

import br.com.arvore.genealogica.exceptions.IntegracaoDadoException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {

	public static final String MSG_ERRO = "Ocorreu algum erro ao criptografar a senha!";

	public static String criptografarSenha(String senha) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(senha.getBytes(),0, senha.length());

			return new BigInteger(1, messageDigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new IntegracaoDadoException(MSG_ERRO);
		}
	}
	
}
