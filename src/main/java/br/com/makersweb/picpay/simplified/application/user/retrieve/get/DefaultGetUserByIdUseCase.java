package br.com.makersweb.picpay.simplified.application.user.retrieve.get;

import br.com.makersweb.picpay.simplified.domain.exceptions.NotFoundException;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import br.com.makersweb.picpay.simplified.domain.user.UserID;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author aaristides
 */
public class DefaultGetUserByIdUseCase extends GetUserByIdUseCase {

    private final UserGateway userGateway;

    public DefaultGetUserByIdUseCase(final UserGateway userGateway) {
        this.userGateway = Objects.requireNonNull(userGateway);
    }

    @Override
    public UserOutput execute(final String anIn) {
        final var anUserID = UserID.from(anIn);

        return this.userGateway.findById(anUserID)
                .map(UserOutput::from)
                .orElseThrow(notFound(anUserID));
    }

    private Supplier<NotFoundException> notFound(final UserID anId) {
        return () -> NotFoundException.with(User.class, anId);
    }

}
