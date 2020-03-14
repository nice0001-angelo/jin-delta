package net.jin.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.userDetailsService(securityUserDetailsService);
		
		httpSecurity.authorizeRequests().antMatchers("/","/system/**").permitAll();
	}

}
