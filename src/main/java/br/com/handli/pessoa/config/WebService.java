package br.com.handli.pessoa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebService extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
            http
            // .authorizeRequests()
            // .anyRequest()
            // .authenticated()
            // .and ()
            // .httpBasic();
            
                .csrf().disable()
                .authorizeRequests()
                   .antMatchers("/**").permitAll();
        }
}
