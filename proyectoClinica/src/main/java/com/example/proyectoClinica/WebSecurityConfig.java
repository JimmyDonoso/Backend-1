package com.example.proyectoClinica;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/crearPaciente.html").hasRole("ADMIN")
                .antMatchers("/listadoPacientes.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }
}
