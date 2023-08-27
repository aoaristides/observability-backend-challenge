package br.com.makersweb.picpay.simplified.domain.transaction;

import br.com.makersweb.picpay.simplified.domain.user.UserType;
import br.com.makersweb.picpay.simplified.domain.validation.Error;
import br.com.makersweb.picpay.simplified.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.simplified.domain.validation.Validator;

/**
 * @author aaristides
 */
public class TransactionValidator extends Validator {

    private final Transaction transaction;

    public TransactionValidator(final Transaction aTransaction, final ValidationHandler aHandler) {
        super(aHandler);
        this.transaction = aTransaction;
    }

    @Override
    public void validate() {
        validateTransaction();
    }

    private void validateTransaction() {
        final var sender = this.transaction.getSender();
        final var senderType = sender.getType();
        final var amount = this.transaction.getAmount();
        if (UserType.MERCHANT.equals(senderType)) {
            this.validationHandler().append(new Error("Usuário do tipo Lojista não está autorizado a realizar transação."));
            return;
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            this.validationHandler().append(new Error("Saldo insuficiente."));
        }
    }
}
