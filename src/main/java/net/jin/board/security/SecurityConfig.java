package net.jin.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.userDetailsService(securityUserDetailsService);
		
		httpSecurity.authorizeRequests().antMatchers("/","/system/**").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/board/**").authenticated();
		httpSecurity.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		httpSecurity.csrf().disable();
		httpSecurity.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true);
		httpSecurity.exceptionHandling().accessDeniedPage("/system/accessDenied");
		httpSecurity.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
	}
}
