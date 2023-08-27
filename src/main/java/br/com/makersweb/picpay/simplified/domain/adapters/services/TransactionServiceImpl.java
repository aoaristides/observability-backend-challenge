package br.com.makersweb.picpay.simplified.domain.adapters.services;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.transaction.CreateTransactionCommand;
import br.com.makersweb.picpay.simplified.domain.dto.TransactionDTO;
import br.com.makersweb.picpay.simplified.domain.ports.interfaces.TransactionServicePort;
import br.com.makersweb.picpay.simplified.domain.ports.interfaces.UserServicePort;
import br.com.makersweb.picpay.simplified.domain.ports.repositories.TransactionRepositoryPort;
import br.com.makersweb.picpay.simplified.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionServicePort {

    private final TransactionRepositoryPort transactionRepositoryPort;
    private final UserServicePort userServicePort;

    @Override
    public TransactionDTO createTransaction(final CreateTransactionCommand createTransactionCommand) {
        log.info("Init method createTransaction by sender_id - {}", createTransactionCommand.aSender());
        final var sender = this.userServicePort.findById(createTransactionCommand.aSender());
        final var receiver = this.userServicePort.findById(createTransactionCommand.aReceiver());
        final var value = createTransactionCommand.aAmount();

       // this.authorizeTransaction(sender, value);


        return null;
    }

    @Override
    public boolean authorizeTransaction(final User sender, final BigDecimal value) {
        return false;
    }
}
