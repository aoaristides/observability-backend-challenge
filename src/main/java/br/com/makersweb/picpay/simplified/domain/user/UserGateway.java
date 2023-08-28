package br.com.makersweb.picpay.simplified.domain.user;

import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author aaristides
 */
public interface UserGateway {

    User create(final User aUser);

    void deleteById(final UserID anId);

    Optional<User> findById(final UserID anId);

    Optional<User> findByDocument(final String aDocument);

    User update(final User aUser);

    Pagination<User> findAll(SearchQuery aQuery);

    List<UserID> existsByIds(Iterable<UserID> ids);

}
