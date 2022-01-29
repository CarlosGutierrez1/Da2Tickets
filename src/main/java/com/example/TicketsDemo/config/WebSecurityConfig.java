package com.example.TicketsDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select usuario, contrasena, disponible from Usuarios where usuario=?")
                .authoritiesByUsernameQuery("select usuario, rol from Usuarios where usuario=?").passwordEncoder(getPasswordEncoded());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers("/pedirsoporte","/registrarsoporte").hasAnyAuthority("ROL_C","ROL_A")
                .antMatchers("/","/login","/registro","/js/**","/css/**","/imgs/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login");
    }


    @Bean
    public PasswordEncoder getPasswordEncoded(){
        return NoOpPasswordEncoder.getInstance();
    }
}
