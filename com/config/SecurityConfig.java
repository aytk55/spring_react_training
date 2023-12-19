package ilanaraba.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("dagasana123")
                .password("123456123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/*").hasRole("ADMIN")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/ilanlar/*").permitAll()
                                .requestMatchers("/filter").permitAll()
                                .requestMatchers("/login").permitAll()


                )
                .formLogin()
                .loginPage("/login") // Kullanıcı girişi için kullanılacak URL
                .defaultSuccessUrl("/admin") // Giriş başarılı olduğunda yönlendirilecek URL// Giriş sayfasına herkesin erişmesine izin ver
                .and()
                .httpBasic(withDefaults());
        return http.build();
    }


}