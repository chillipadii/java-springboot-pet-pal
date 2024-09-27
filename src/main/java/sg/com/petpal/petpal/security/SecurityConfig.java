package sg.com.petpal.petpal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        int saltLength = 16; // 16 bytes salt
        int hashLength = 32; // 32 bytes hash
        int parallelism = 1; // Single-threaded
        int memory = 1 << 12; // 4 MB of memory
        int iterations = 3; // 3 iterations
        return new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
    }
}
