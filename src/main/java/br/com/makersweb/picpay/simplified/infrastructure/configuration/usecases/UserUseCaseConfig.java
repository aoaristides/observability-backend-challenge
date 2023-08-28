package br.com.makersweb.picpay.simplified.infrastructure.configuration.usecases;

import br.com.makersweb.picpay.simplified.application.user.create.CreateUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.create.DefaultCreateUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.delete.DefaultDeleteUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.delete.DeleteUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.get.DefaultGetUserByIdUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.get.GetUserByIdUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.list.DefaultListUsersUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.list.ListUsersUseCase;
import br.com.makersweb.picpay.simplified.application.user.update.DefaultUpdateUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.update.UpdateUserUseCase;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class UserUseCaseConfig {

    private final UserGateway userGateway;

    public UserUseCaseConfig(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new DefaultCreateUserUseCase(userGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase() {
        return new DefaultUpdateUserUseCase(userGateway);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase() {
        return new DefaultGetUserByIdUseCase(userGateway);
    }

    @Bean
    public ListUsersUseCase listUsersUseCase() {
        return new DefaultListUsersUseCase(userGateway);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase() {
        return new DefaultDeleteUserUseCase(userGateway);
    }
}
