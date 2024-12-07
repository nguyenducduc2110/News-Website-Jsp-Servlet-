
package com.webspringmvc.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.webspringmvc.auth.security.CustomSuccessHandler;
import com.webspringmvc.auth.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration  extends WebSecurityConfigurerAdapter {
	
		@Autowired
	    private CustomSuccessHandler customSuccessHandler;
	 
	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;
	    
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            	
	                .antMatchers("/quan-tri/**").hasAuthority("ADMIN")	
	                .antMatchers("/trang-chu").permitAll()
	                .antMatchers("/sign-up").permitAll()
	                .antMatchers("/bai-viet/chinh-sua").authenticated()     
	                
	                .and()
	            
	            .formLogin()
	                .loginPage("/dang-nhap")
	                .usernameParameter("j_username")
	                .passwordParameter("j_password")
	                .loginProcessingUrl("/j_spring_security_check") 
	                .successHandler(customSuccessHandler)
	                .failureUrl("/dang-nhap?incorrectAccount")
	                .permitAll()
	                .and()	           
	            .logout()
	                .logoutUrl("/thoat")
	                .logoutSuccessUrl("/trang-chu")
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	                .and()
	            .exceptionHandling()
	                .accessDeniedPage("/dang-nhap?accessDenied=true")
	                .and()
	            .csrf()
	                .csrfTokenRepository(csrfTokenRepository())
	                .and()
	            .sessionManagement()
	                .maximumSessions(100)
	                .maxSessionsPreventsLogin(true)
	                .expiredUrl("/timeout");
	    }

	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }

	    
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(customUserDetailsService);
	        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	        return authProvider;
	    }

	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public CsrfTokenRepository csrfTokenRepository() {
	        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	        repository.setSessionAttributeName("_csrf");
	        return repository;
	    }
	    @Bean
	    public CustomSuccessHandler customSuccessHandler() {
	        return new CustomSuccessHandler();
	    }
}
