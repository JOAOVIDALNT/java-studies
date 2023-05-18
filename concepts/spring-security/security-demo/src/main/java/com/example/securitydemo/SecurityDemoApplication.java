package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }


    @RestController
    class HttpController {
        @GetMapping("/public")
        String publicRoute() {
            return "<h1> Public route, none authorization required </h1>";
        }

        @GetMapping("/private")
        String privateRoute(@AuthenticationPrincipal OidcUser principal) { // Oidc = OpenIdConnect
            return String.format("<h1> Private route, authorization required </h1>");
        }

        @GetMapping("/cookie")
        String cookie(@AuthenticationPrincipal OidcUser principal) { // Oidc = OpenIdConnect
            return String.format(
                    """
                    <h1> OAuth2 </h1>
                    <h3>Principal: %s</h3>
                    <h3>Email attribute: %s</h3>
                    <h3>Authorities: %s</h3>
                    <h3>JWT: %s</h3>
                    """, principal, principal.getAttribute("email"), principal.getAuthorities(),
                    principal.getIdToken().getTokenValue()
            );
        }

        @GetMapping("/jwt")
        String jwt(@AuthenticationPrincipal Jwt jwt) {
            return String.format("""
                    <h1> JWT </h1>
                    Principal: %s\n
                    Email attribute: %s\n
                    JWT: %s\n
                   
                    """, jwt.getClaims(), jwt.getClaim("email"), jwt.getTokenValue());
        }

    }

}
