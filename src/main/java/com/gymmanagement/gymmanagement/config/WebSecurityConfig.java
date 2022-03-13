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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * method to configure security
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Cross-origin-resource-sharing
        //permitted and unpermitted paths according to roles
        http.cors().and()
                .authorizeRequests()
                //These are public pages.
                .antMatchers(
                        "/error",
                        "/api/role/**",
                        "/api/activity/all",
                        "/api/schedule/all",
                        "/api/schedule/{date}/all",
                        "/api/ticket-type/all",
                        "/api/user-auth/registration",
                        "/api/user-auth/login",
                        "/api/user-auth/logout",
                        "/api/user/generate_reset_token/{username}",
                        "/api/user/find_by_token/{token}",
                        "/api/user/token_validation/{token}",
                        "/api/user/{id}/edit",
                        "/api/user/{id}",
                        "/api/user/{id}/edit-password"
                ).permitAll()
                //These can be reachable for just have user role.
                .antMatchers(
                        "/api/enrollment/sign_up",
                        "/api/enrollment/{id}/all_by_user",
                        "/api/enrollment/{id}",
                        "/api/enrollment/{id}/delete",
                        "/api/enrollment/{id_position}/{id_user}",

                        "/api/schedule/{id}",
                        "/api/schedule/{id}/edit",

                        "/api/ticket/all/{id_user}",
                        "/api/ticket/all",
                        "/api/ticket/save",
                        "/api/ticket/update",

                        "/api/ticket-type/{id}",

                        "/api/user_role/{id}/add",

                        "/api/role/{name}"
                        ).hasAnyRole("USER", "ADMIN", "STAFF")
                //These can be reachable for just have admin role.
                .antMatchers(
                        "/api/activity/add",
                        "/api/activity/{id}/edit",
                        "/api/activity/{id}",
                        "/api/activity/{id}/delete",

                        "/api/enrollment/{id}/all_by_position",


                        "/api/schedule/add",
                        "/api/schedule/{id}/delete",
                        "/api/schedule/delete",
                        "/api/schedule/copy",

                        "/api/ticket/{id_ticket}",
                        "/api/ticket/{id_ticket}/delete",

                        "/api/ticket-type/add",
                        "/api/ticket-type/{id}/edit",
                        "/api/ticket-type/{id}/delete",

                        "/api/user/all",
                        "/api/user/{role_name}/all_by_role"
                )
                .hasAnyRole("ADMIN", "STAFF")
                //all remaining paths should need authentication.
                .anyRequest().fullyAuthenticated()
                .and()
                //logout will log the user out by invalidate session.
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/user-auth/logout", "POST")).and()
                //login form and path
                .formLogin().loginPage("/api/user-auth/login").and()
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
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}

//TODO
//po najechaniu na "zapisz się" komunikat, że zajęcia już się odbyły
