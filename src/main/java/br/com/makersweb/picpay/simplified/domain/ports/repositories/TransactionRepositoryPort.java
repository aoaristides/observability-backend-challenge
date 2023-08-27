package br.com.makersweb.picpay.simplified.domain.ports.repositories;

import br.com.makersweb.picpay.simplified.domain.ports.command.transaction.InsertTransactionCommand;
import br.com.makersweb.picpay.simplified.domain.transaction.Transaction;

/**
 * @author aaristides
 */
public interface TransactionRepositoryPort {

    Transaction save(final InsertTransactionCommand insertTransactionCommand);

}
