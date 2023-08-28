package br.com.makersweb.picpay.simplified.application.user.update;

import br.com.makersweb.picpay.simplified.application.UseCase;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;
import io.vavr.control.Either;

/**
 * @author aaristides
 */
public abstract class UpdateUserUseCase
        extends UseCase<UpdateUserCommand, Either<Notification, UpdateUserOutput>> {
}
