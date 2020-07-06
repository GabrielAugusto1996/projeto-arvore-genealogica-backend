package br.com.arvore.genealogica.factories.usuario;


import br.com.arvore.genealogica.dto.usuario.UsuarioDTO;
import br.com.arvore.genealogica.models.Usuario;

import java.time.LocalDate;

public final class UsuarioFactory {

    private UsuarioFactory() {
    }

    public static Usuario criar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getNome());
        usuario.setSenha(usuarioDTO.getNome());
        usuario.setCelular(usuarioDTO.getNome());
        usuario.setDataCadastro(LocalDate.now());

        return usuario;
    }
}
