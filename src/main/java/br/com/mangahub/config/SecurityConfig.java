package br.com.mangahub.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/images/**", "/", "/index.html")
                .permitAll()
			    .and()
            .formLogin()
                .loginPage("/logar")
                .permitAll()
                .and()
            .logout()
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {    	
         JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
         manager.setUsersByUsernameQuery("select email, password, true "
                                         + "from users "
                                         + "where email = ? and users.deleted_at is null");
         
        manager.setAuthoritiesByUsernameQuery(
                 "SELECT users.email , roles.name FROM users where users.email = ? and users.deleted_at is null"
               + " INNER JOIN roles_users ON user_id = users.id "
               + " INNER JOIN roles ON role_id = roles.id;");

         return manager;
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

}
