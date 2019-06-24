package ninja.zhancheng.tacospring.Config;

import ninja.zhancheng.tacospring.Services.Impl.UserRepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web
        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
        .configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepositoryUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll() // needed for Angular/CORS
                .antMatchers(HttpMethod.POST).permitAll()
//                .antMatchers("/design", "/orders")
//                .permitAll()
//                .access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.PATCH, "/ingredients").permitAll()
                .antMatchers("/", "/**").permitAll()


                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design", true)

                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**", "/ingredients/**", "/design", "/orders", "/api/**")


                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .cors()
        ;
                

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }



}

