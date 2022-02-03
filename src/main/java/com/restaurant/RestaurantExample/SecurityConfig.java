package com.restaurant.RestaurantExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.net.URI;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri(URI.create("https://cosimospage.herokuapp.com/"));
        return successHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers(

                        HttpMethod.GET,
                        Endpoints.HOMEPAGE,
                        Endpoints.TEST,
                        Endpoints.SPEISEKARTE

                ).permitAll()
                .antMatchers(
                        "/css/**",
                        "/bilder/**",
                        "/effects/**"
                ).permitAll()
                .anyRequest().authenticated()

                .and().logout().logoutSuccessHandler(oidcLogoutSuccessHandler())

                .and()
                .oauth2Client()
                .and()
                .oauth2Login();
        http.cors().and().csrf().disable();
    }


}
