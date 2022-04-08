package com.mobile.mobileAppTest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mobile.mobileAppTest.PasswordConfig;
import com.mobile.mobileAppTest.appUser.AppUserService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
   private AppUserService appUserService;
	
	  @Autowired
		 private BCryptPasswordEncoder  bCryptPasswordEncoder;
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
	    filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

	    http.
     csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        .antMatchers("/api/v1/registration/**").permitAll()
        .antMatchers("/users/post/**").hasAuthority("USER")
        .antMatchers("/post/actions/**").hasAuthority("USER")
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
		
				
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider() );
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(); 
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }

}
