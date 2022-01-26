package com.dormitoryservice.project.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null)
                return user;

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/insertMenu/{id}", "/showNewFoodForm", "/saveFood", "/showFormForUpdate/{id}", "/deleteFood/{id}").access("hasRole('FOOD')")
                .antMatchers("/edit/**", "/deleteLaundry/**", "/saveLaundry").access("hasRole('LAUNDRY')")
                .antMatchers("/login", "/laundryregister", "/foodregister" ).access("permitAll()")
                .antMatchers("/", "/**").access("permitAll()")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/service")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }
}
