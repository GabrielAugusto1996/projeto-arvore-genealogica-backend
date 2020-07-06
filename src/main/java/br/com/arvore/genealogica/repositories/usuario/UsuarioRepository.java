package br.com.arvore.genealogica.repositories.usuario;

import br.com.arvore.genealogica.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT NEW br.com.arvore.genealogica.models.Usuario(u.codigo, u.email, u.senha) " +
            "FROM Usuario u " +
            "WHERE u.email = :email")
    Usuario findByEmail(String email);
}
