package br.com.makersweb.picpay.simplified.domain.ports.interfaces;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.transaction.CreateTransactionCommand;
import br.com.makersweb.picpay.simplified.domain.dto.TransactionDTO;
import br.com.makersweb.picpay.simplified.domain.user.User;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
public interface TransactionServicePort {

    TransactionDTO createTransaction(final CreateTransactionCommand createTransactionCommand);

    boolean authorizeTransaction(final User sender, final BigDecimal value);

}
