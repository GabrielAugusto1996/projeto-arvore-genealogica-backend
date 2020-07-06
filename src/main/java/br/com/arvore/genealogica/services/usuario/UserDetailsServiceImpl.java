package br.com.arvore.genealogica.services.usuario;

import br.com.arvore.genealogica.models.Usuario;
import br.com.arvore.genealogica.repositories.usuario.UsuarioRepository;
import br.com.arvore.genealogica.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) {
		Usuario usuario = this.usuarioRepository.findByEmail(email);

		this.validarUsuarioEncontrado(email, usuario);

		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		return new UserSS(usuario.getCodigo(), usuario.getEmail(), encode.encode(usuario.getSenha()));
	}

	private void validarUsuarioEncontrado(String email, Usuario usuario) {
		if (isNull(usuario)) {
			throw new UsernameNotFoundException(email);
		}
	}
}
