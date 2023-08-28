package br.com.makersweb.picpay.simplified.application.user.delete;

import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import br.com.makersweb.picpay.simplified.domain.user.UserID;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultDeleteUserUseCase extends DeleteUserUseCase {

    private final UserGateway userGateway;

    public DefaultDeleteUserUseCase(final UserGateway userGateway) {
        this.userGateway = Objects.requireNonNull(userGateway);
    }

    @Override
    public void execute(final String anIn) {
        this.userGateway.deleteById(UserID.from(anIn));
    }
}
