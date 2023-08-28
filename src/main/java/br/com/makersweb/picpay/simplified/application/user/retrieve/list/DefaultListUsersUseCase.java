package br.com.makersweb.picpay.simplified.application.user.retrieve.list;

import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultListUsersUseCase extends ListUsersUseCase {

    private final UserGateway userGateway;

    public DefaultListUsersUseCase(final UserGateway userGateway) {
        this.userGateway = Objects.requireNonNull(userGateway);
    }

    @Override
    public Pagination<UserListOutput> execute(final SearchQuery aQuery) {
        return this.userGateway.findAll(aQuery).map(UserListOutput::from);
    }
}
