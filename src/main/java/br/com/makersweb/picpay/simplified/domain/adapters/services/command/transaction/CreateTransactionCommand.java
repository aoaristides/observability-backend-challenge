package br.com.makersweb.picpay.simplified.domain.adapters.services.command.transaction;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param aAmount
 * @param aSender
 * @param aReceiver
 */
public record CreateTransactionCommand(BigDecimal aAmount, String aSender, String aReceiver) {

    public CreateTransactionCommand with(final BigDecimal aAmount, final String aSender, final String aReceiver) {
        return new CreateTransactionCommand(aAmount, aSender, aReceiver);
    }

}
