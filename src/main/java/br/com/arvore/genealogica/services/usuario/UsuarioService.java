package br.com.arvore.genealogica.services.usuario;

import br.com.arvore.genealogica.dto.usuario.UsuarioDTO;
import br.com.arvore.genealogica.exceptions.NegocioException;
import br.com.arvore.genealogica.factories.usuario.UsuarioFactory;
import br.com.arvore.genealogica.models.Usuario;
import br.com.arvore.genealogica.repositories.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class UsuarioService {

    private static final String MSG_ERRO_USUARIO_COM_MESMO_EMAIL = "Já possuí um usuário com esse e-mail.";

    private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario salvar(UsuarioDTO usuarioDTO) {
		Usuario usuarioAtual = this.usuarioRepository.findByEmail(usuarioDTO.getEmail());

		this.validarExisteUsuarioPorEmail(usuarioAtual);

		Usuario usuario = UsuarioFactory.criar(usuarioDTO);

		return this.usuarioRepository.save(usuario);
	}

	private void validarExisteUsuarioPorEmail(Usuario usuarioAtual) {
		if (nonNull(usuarioAtual)) {
            throw new NegocioException(MSG_ERRO_USUARIO_COM_MESMO_EMAIL);
        }
	}
}
