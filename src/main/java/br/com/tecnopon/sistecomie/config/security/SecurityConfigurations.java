package br.com.tecnopon.sistecomie.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    @Autowired
    public SecurityConfigurations(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        //.antMatchers(HttpMethod.GET,"/repairs").permitAll()
        //.antMatchers(HttpMethod.GET, "/repairs/*").permitAll()
        //.antMatchers(HttpMethod.GET,"/customers").permitAll()
        //.antMatchers(HttpMethod.GET,"/customers/*").permitAll()
        .antMatchers("/customers").permitAll()
        .antMatchers("/customers/*").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin()
        //.and().csrf().ignoringAntMatchers("/h2-console/**")
          //      .and.csrf().ignoringAntMatchers("/customers")
        .and().headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
