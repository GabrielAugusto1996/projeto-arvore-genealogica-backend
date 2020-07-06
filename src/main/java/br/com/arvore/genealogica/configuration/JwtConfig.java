package br.com.arvore.genealogica.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public ContextJwt getContextJwt() {
        return new ContextJwt(this.secret, this.expiration);
    }

    public class ContextJwt {
        public ContextJwt(String secret, Long expiration) {
            this.secret = secret;
            this.expiration = expiration;
        }

        private String secret;
        private Long expiration;

        public Long getExpiration() {
            return expiration;
        }

        public void setExpiration(Long expiration) {
            this.expiration = expiration;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
