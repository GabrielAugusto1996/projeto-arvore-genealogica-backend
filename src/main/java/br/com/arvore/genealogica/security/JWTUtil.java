package br.com.arvore.genealogica.security;

import br.com.arvore.genealogica.configuration.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.util.Objects.nonNull;

@Component
public class JWTUtil {
	
	private final JwtConfig.ContextJwt contextJwt;

	public JWTUtil(JwtConfig.ContextJwt contextJwt) {
		this.contextJwt = contextJwt;
	}

	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + this.contextJwt.getExpiration()))
				.signWith(SignatureAlgorithm.HS512, this.contextJwt.getSecret().getBytes())
				.compact();
	}
	
	boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (nonNull(claims)) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			return (nonNull(username) && nonNull(expirationDate) && now.before(expirationDate));
		}
		return false;
	}

	String getUsername(String token) {
		Claims claims = getClaims(token);
		return nonNull(claims) ? claims.getSubject() : null;
	}
	
	private Claims getClaims(String token) {
		Claims claims;

		try {
			claims = Jwts.parser().setSigningKey(this.contextJwt.getSecret().getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			claims = null;
		}

		return claims;
	}
}
