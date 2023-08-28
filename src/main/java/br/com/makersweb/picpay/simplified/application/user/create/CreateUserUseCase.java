package br.com.makersweb.picpay.simplified.application.user.create;

import br.com.makersweb.picpay.simplified.application.UseCase;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;
import io.vavr.control.Either;

/**
 * @author aaristides
 */
public abstract class CreateUserUseCase
        extends UseCase<CreateUserCommand, Either<Notification, CreateUserOutput>> {
}
