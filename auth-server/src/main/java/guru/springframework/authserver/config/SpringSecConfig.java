package guru.springframework.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by jt, Spring Framework Guru.
 */
@Configuration
public class SpringSecConfig {
//    @Bean
//    @Order(1)
//    public SecurityFilterChain actuatorSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        http.oauth2ResourceServer((oauth2) -> oauth2
                .jwt(Customizer.withDefaults()));

        return http.build();
    }
}
