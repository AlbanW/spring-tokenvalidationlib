package fr.albanw.lib;


import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.oauth2.jwt.*;

import java.time.Instant;
import java.util.Map;

public classTokenUtils {

    private JwtDecoder jwtDecoder;

    public TokenUtils(JWK jwk) {
        // Configure JwtEncoder
        JWKSource<SecurityContext> jwkSource = (jwkSelector, context) -> new JWKSet(jwk).getKeys();
        this.jwtDecoder = NimbusJwtDecoder.withSecretKey(jwk.toOctetSequenceKey().toSecretKey()).build();
    }

    /**
     * Validate and parse a JWT token.
     * @param token The JWT token.
     * @return Decoded JWT claims.
     * @throws JwtException If the token is invalid.
     */
    public Jwt validateToken(String token) throws JwtException {
        return jwtDecoder.decode(token);
    }
}
