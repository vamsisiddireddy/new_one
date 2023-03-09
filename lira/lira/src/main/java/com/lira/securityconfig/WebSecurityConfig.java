package com.lira.securityconfig;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.lira.service.EmployeeService;
import com.lira.service.EmployeeServiceImpl;


@Configuration
@EnableWebMvc
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
		
	@Autowired 
	DataSource dataSource;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Resource(name = "employeeService")
	private EmployeeService employeeService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
    
    	
		// Setting Service to find User in the database.
        // And Setting PassswordEncoder
    	auth.jdbcAuthentication().dataSource(dataSource)
    	.authoritiesByUsernameQuery("select USERNAME, ROLE from employee where USERNAME=?")
        .usersByUsernameQuery("select USERNAME, PASSWORD, 1 as enabled  from employee where USERNAME=?");
    	
    }
 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		 .antMatchers("lira/welcome").access("hasRole('USER')")
	        .antMatchers("lira/welcome1/**").access("hasRole('HOD')")		
		
		
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/lira/login").successHandler(customSuccessHandler)
				.loginProcessingUrl("/authenticateTheUser")
				.usernameParameter("username")
                .passwordParameter("password")
				.permitAll()
				.and().logout()    //logout configuration
				.logoutSuccessUrl("/lira/login");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {

		 web.ignoring().antMatchers("/css/**");
	        web.ignoring().antMatchers("/scripts/**");
	        web.ignoring().antMatchers("/images/**");
		
	}
	
	
}
