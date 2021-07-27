package com.tuncer.moviecreator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tuncer.moviecreator.service.impl.UserServiceImpl;
import com.tuncer.moviecreator.types.RoleType;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserServiceImpl userService; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/users/**").hasAnyRole(RoleType.ROLE_ADMIN.name())
				.antMatchers("/movie/**").hasAnyRole(RoleType.ROLE_USER.name(),RoleType.ROLE_ADMIN.name())
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/signup").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and().csrf().ignoringAntMatchers("/h2-console/**")
		        .and().headers().frameOptions().sameOrigin();
	}

	// TODO It's not working with user entity
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}