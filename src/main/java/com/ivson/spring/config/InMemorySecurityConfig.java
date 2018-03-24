package com.ivson.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * So de adicoinar o Spring Security no POM, ja temos que logar atraves da senha oferecida no CONSOLE
 * @author Santo
 *
 */
@Configuration
public class InMemorySecurityConfig {

	/**
	 * Para autenticacao em memoria
	 * @param builder
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	
		builder.inMemoryAuthentication()
				.withUser("joao").password("123").roles("USER")
				.and()
				.withUser("alexandre").password("123").roles("USER")
				.and()
				.withUser("thiago").password("123").roles("USER");
		}
}
