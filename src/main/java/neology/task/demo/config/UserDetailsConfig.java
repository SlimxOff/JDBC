package neology.task.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userRead = User.withDefaultPasswordEncoder()
                .username("userRead")
                .password("password")
                .roles("READ")
                .build();

        UserDetails userWrite = User.withDefaultPasswordEncoder()
                .username("userWrite")
                .password("password")
                .roles("WRITE")
                .build();

        UserDetails userDelete = User.withDefaultPasswordEncoder()
                .username("userDelete")
                .password("password")
                .roles("DELETE")
                .build();

        UserDetails userReadWrite = User.withDefaultPasswordEncoder()
                .username("userReadWrite")
                .password("password")
                .roles("READ", "WRITE")
                .build();

        return new InMemoryUserDetailsManager(userRead, userWrite, userDelete, userReadWrite);
    }
}