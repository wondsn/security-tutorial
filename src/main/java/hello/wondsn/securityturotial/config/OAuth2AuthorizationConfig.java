package hello.wondsn.securityturotial.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientId")
                .secret("{noop}clientSecret")
                .redirectUris("http://localhost:8081/oauth2/callback")
                .authorizedGrantTypes("authorization_code", "password")
                .scopes("read", "write")
                .accessTokenValiditySeconds(60 * 60 * 4)
                .refreshTokenValiditySeconds(60 * 60 * 24 * 120)
                .autoApprove(true);
    }
}
