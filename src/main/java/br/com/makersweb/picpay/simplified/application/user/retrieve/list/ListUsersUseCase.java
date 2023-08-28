package br.com.makersweb.picpay.simplified.application.user.retrieve.list;

import br.com.makersweb.picpay.simplified.application.UseCase;
import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;

/**
 * @author aaristides
 */
public abstract class ListUsersUseCase
        extends UseCase<SearchQuery, Pagination<UserListOutput>> {
}
