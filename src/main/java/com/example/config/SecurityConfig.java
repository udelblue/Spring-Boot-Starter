package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	
	@Value("${db.driver}")
	private String DB_DRIVER;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
	
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		// point to database in datasource below is sql to add a test user
		// insert into user ( id , enabled , password , username ) values ( 1,1,'password','user');
		// insert into role (id, username , role ) values ( 1 , 'user', 'ROLE_USER' );
		
		
//		  auth.jdbcAuthentication().dataSource(dataSource())
//			.usersByUsernameQuery(
//				"select username,password, enabled from user where username=?")
//			.authoritiesByUsernameQuery(
//				"select username , role  from user join user_role on user_role.user_user_id = user.user_id join role on role.role_id = user_role.roles_role_id where username=?");
		
		
		
		//in memory database
	  auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("password").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		//.antMatchers("/**").access("hasRole('ROLE_USER')")
		.antMatchers("/**").permitAll()
		
		.and().formLogin().and().csrf().disable();

	}
}