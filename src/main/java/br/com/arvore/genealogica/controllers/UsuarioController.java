package br.com.arvore.genealogica.controllers;

import br.com.arvore.genealogica.dto.usuario.UsuarioDTO;
import br.com.arvore.genealogica.models.Usuario;
import br.com.arvore.genealogica.services.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = this.usuarioService.salvar(usuarioDTO);

        return ResponseEntity.status(CREATED).body(usuario);
    }

}
