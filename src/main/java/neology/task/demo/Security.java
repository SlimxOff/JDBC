package neology.task.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/products/fetch-product").permitAll() // Доступ без авторизации
                        .anyRequest().authenticated() // Все остальные запросы требуют авторизации
                )
                .formLogin(formLogin -> formLogin // Включаем стандартную форму логина от Spring
                        .defaultSuccessUrl("/", true)
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // Отключаем базовую HTTP аутентификацию

        return http.build();
    }
}