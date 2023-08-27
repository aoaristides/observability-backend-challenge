package br.com.makersweb.picpay.simplified.infrastructure.configuration;

import br.com.makersweb.picpay.simplified.domain.adapters.services.UserServiceImpl;
import br.com.makersweb.picpay.simplified.domain.ports.interfaces.UserServicePort;
import br.com.makersweb.picpay.simplified.domain.ports.repositories.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class BeanConfiguration {

    @Bean
    UserServicePort userService(UserRepositoryPort userRepositoryPort) {
        return new UserServiceImpl(userRepositoryPort);
    }

}
