package id.co.tripoin.account.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Configuration
@EnableAuthorizationServer
public class ConfigAuthServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Autowired private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
        .withClient("authcodeclient")
            .secret("authcode321")
            .resourceIds("marketplace")
            .redirectUris("http://example.com")
            .authorizedGrantTypes("authorization_code","refresh_token")
            .authorities("APP_CLIENT_OAUTH2")
            .scopes("read", "write", "trust")
            .accessTokenValiditySeconds(1800)
            .refreshTokenValiditySeconds(18000)
            .autoApprove(true)
        .and().withClient("implicitclient")
            .resourceIds("marketplace")
            .redirectUris("http://example.com")
            .authorizedGrantTypes("implicit")
            .authorities("APP_CLIENT_OAUTH2")
            .scopes("read", "write", "trust")
        .and().withClient("userpassword")
            .secret("userpassword001")
            .resourceIds("marketplace")
            .redirectUris("http://example.com")
            .authorizedGrantTypes("password")
            .authorities("APP_CLIENT_OAUTH2")
            .scopes("read", "write", "trust")
            .accessTokenValiditySeconds(1800)
            .refreshTokenValiditySeconds(18000)
            .autoApprove(true)
        .and().withClient("clientapp")
            .secret("clientapp999")
            .resourceIds("marketplace")
            .redirectUris("http://example.com")
            .authorizedGrantTypes("client_credentials")
            .authorities("APP_CLIENT_OAUTH2")
            .scopes("read", "write", "trust")
            .accessTokenValiditySeconds(1800)
            .refreshTokenValiditySeconds(18000)
            .autoApprove(true)
        ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("hasAuthority('APP_CLIENT_OAUTH2')")
                .tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }
}
