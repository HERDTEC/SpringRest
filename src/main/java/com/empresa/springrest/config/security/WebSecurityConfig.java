package com.empresa.springrest.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.empresa.springrest.repository.UsuarioRepository;
import com.empresa.springrest.service.UsuarioService;

@Configuration
@EnableWebSecurity
//@Profile("development")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	 private static final String[] AUTH_WHITELIST = {
	            "/swagger-resources/**",
	            "/swagger-ui.html",
	            "/configuration/ui",
	            "/configuration/security",
	            "/v2/api-docs",
	            "/webjars/**"
	    };
   
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN").and()
//                .withUser("jorge").password("jorge").roles("USER");
//    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService);
	}
	
	

	@Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-"
        		+ "docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		 		.antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers("/login").permitAll() // permitimos el acceso a /login a cualquiera
				.anyRequest().authenticated() // cualquier otra peticion requiere autenticacion
				.and()
				// Las peticiones /login pasaran previamente por este filtro
				.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)

				// Las demás peticiones pasarán por este filtro para validar el token
				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
