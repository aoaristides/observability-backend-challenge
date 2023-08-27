package br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories.impl;

import br.com.makersweb.picpay.simplified.domain.ports.command.transaction.InsertTransactionCommand;
import br.com.makersweb.picpay.simplified.domain.ports.repositories.TransactionRepositoryPort;
import br.com.makersweb.picpay.simplified.domain.transaction.Transaction;
import br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories.TransactionJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
@AllArgsConstructor
public class TransactionRepository implements TransactionRepositoryPort {

    private final TransactionJpaRepository repository;

    @Override
    public Transaction save(final InsertTransactionCommand insertTransactionCommand) {
        return null;
    }

}
