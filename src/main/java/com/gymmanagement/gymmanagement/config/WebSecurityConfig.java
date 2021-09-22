package com.gymmanagement.gymmanagement.config;

import com.gymmanagement.gymmanagement.jwt.JwtAuthorizationFilter;
import com.gymmanagement.gymmanagement.jwt.JwtTokenProvider;
import com.gymmanagement.gymmanagement.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Cross-origin-resource-sharing
        http.cors().and()
                .authorizeRequests()
                //These are public pages.
                .antMatchers(
                        "/resources/**",
                        "/error",
                        "/api/user/registration",
                        "/api/user/login",
                        "/api/ticket-type/all",
                        "/api/activity/**",
                        "/api/ticket-type/{id}",
                        "/api/ticket-type/add",
                        "/api/ticket-type/{id}/edit",
                        "/api/ticket-type/{id}/delete"
                        ).permitAll()
                //These can be reachable for just have user role.
                .antMatchers(
                        "/api/user/{id}/edit",
                        "/api/user/{id}/edit-password",
                        "/api/ticket/all/{id}"
                        )
                .hasRole("USER")
                //These can be reachable for just have admin role.
                .antMatchers(
                        "/api/admin/**"
                        )
                .hasRole("ADMIN")
                //all remaining paths should need authentication.
                .anyRequest().fullyAuthenticated()
                .and()
                //logout will log the user out by invalidate session.
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout", "POST")).and()
                //login form and path
                .formLogin().loginPage("/api/user/login").and()
                //enable basic authentication. Http header: basis username:password
                .httpBasic().and()
                //Cross side request forgery.
                .csrf().disable();

        http.addFilter(new JwtAuthorizationFilter(authenticationManager(), tokenProvider));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //Cross origin resource sharing.
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
