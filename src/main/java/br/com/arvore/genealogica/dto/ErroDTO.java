package br.com.arvore.genealogica.dto;

public class ErroDTO {
    private final String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public ErroDTO(String mensagem) {
        this.mensagem = mensagem;
    }
}
