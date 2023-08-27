package br.com.makersweb.picpay.simplified.domain.ports.command.transaction;

import br.com.makersweb.picpay.simplified.domain.user.User;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param aAmount
 * @param aSender
 * @param aReceiver
 */
public record InsertTransactionCommand(BigDecimal aAmount, User aSender, User aReceiver) {

    public InsertTransactionCommand with(final BigDecimal aAmount, final User aSender, final User aReceiver) {
        return new InsertTransactionCommand(aAmount, aSender, aReceiver);
    }

}
