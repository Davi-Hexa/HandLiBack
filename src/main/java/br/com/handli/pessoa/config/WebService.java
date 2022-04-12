package br.com.handli.pessoa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebService extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                // .sessionManagement(SessionCreationPolicy.STATELESS)
                .authorizeRequests()
                    .antMatchers("/**").permitAll();
        }
}

