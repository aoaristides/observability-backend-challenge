package br.com.makersweb.picpay.simplified.application.user.update;

import br.com.makersweb.picpay.simplified.domain.exceptions.DomainException;
import br.com.makersweb.picpay.simplified.domain.exceptions.NotFoundException;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import br.com.makersweb.picpay.simplified.domain.user.UserID;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

/**
 * @author aaristides
 */
public class DefaultUpdateUserUseCase extends UpdateUserUseCase {

    private final UserGateway userGateway;

    public DefaultUpdateUserUseCase(final UserGateway userGateway) {
        this.userGateway = Objects.requireNonNull(userGateway);
    }

    @Override
    public Either<Notification, UpdateUserOutput> execute(final UpdateUserCommand aCommand) {
        final var anId = UserID.from(aCommand.id());
        final var firstName = aCommand.firstName();
        final var lastName = aCommand.lastName();
        final var document = aCommand.document();
        final var mail = aCommand.mail();
        final var password = aCommand.password();
        final var balance = aCommand.balance();
        final var type = aCommand.type();
        final var active = aCommand.isActive();

        final var aUser = this.userGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        aUser.update(firstName, lastName, document, mail, password, balance, type, active)
                .validate(notification);

        return notification.hasError() ? Left(notification) : update(aUser);
    }

    private Either<Notification, UpdateUserOutput> update(final User aUser) {
        return Try(() -> this.userGateway.update(aUser))
                .toEither()
                .bimap(Notification::create, UpdateUserOutput::from);
    }

    private Supplier<DomainException> notFound(final UserID anId) {
        return () -> NotFoundException.with(User.class, anId);
    }
}
