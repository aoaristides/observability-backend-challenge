package br.com.makersweb.picpay.simplified.domain.transaction;

import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;

import java.util.Optional;

/**
 * @author aaristides
 */
public interface TransactionGateway {

    Transaction create(final Transaction aTransaction);

    void deleteById(final TransactionID anId);

    Optional<Transaction> findById(final TransactionID anId);

    Transaction update(final Transaction aTransaction);

    Pagination<Transaction> findAll(SearchQuery aQuery);

}
