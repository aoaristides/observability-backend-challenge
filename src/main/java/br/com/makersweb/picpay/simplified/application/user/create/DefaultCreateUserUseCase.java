package br.com.makersweb.picpay.simplified.application.user.create;

import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

/**
 * @author aaristides
 */
public class DefaultCreateUserUseCase extends CreateUserUseCase {

    private final UserGateway userGateway;

    public DefaultCreateUserUseCase(final UserGateway userGateway) {
        this.userGateway = Objects.requireNonNull(userGateway);
    }

    @Override
    public Either<Notification, CreateUserOutput> execute(final CreateUserCommand aCommand) {
        final var firstName = aCommand.firstName();
        final var lastName = aCommand.lastName();
        final var document = aCommand.document();
        final var mail = aCommand.mail();
        final var password = aCommand.password();
        final var balance = aCommand.balance();
        final var type = aCommand.type();
        final var active = aCommand.isActive();

        final var notification = Notification.create();

        final var aUser = User.newUser(firstName, lastName, document, mail, password, balance, type, active);
        aUser.validate(notification);

        return notification.hasError() ? Left(notification) : create(aUser);
    }

    private Either<Notification, CreateUserOutput> create(final User aUser) {
        return Try(() -> this.userGateway.create(aUser))
                .toEither()
                .bimap(Notification::create, CreateUserOutput::from);
    }
}
