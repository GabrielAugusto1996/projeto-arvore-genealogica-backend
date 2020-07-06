package br.com.arvore.genealogica.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserSecurity {

    private UserSecurity() {
        throw new UnsupportedOperationException("Não é possível instanciar essa classe.");
    }

    public static UserSS authenticated() {
        UserSS userSS;

        try {
            userSS = (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            userSS = null;
        }

        return userSS;
	}
}
