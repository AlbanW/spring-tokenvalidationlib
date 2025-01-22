package fr.albanw.lib;

public class TokenValidator {

    public static String getToken() {
        return "toto";
    }
    @Bean
    public JwtDecoder jwtDecoder(JWK jwk) {
        System.out.println(TokenValidator.getToken());
        return NimbusJwtDecoder.withSecretKey(jwk.toOctetSequenceKey().toSecretKey()).build();
    }
}
