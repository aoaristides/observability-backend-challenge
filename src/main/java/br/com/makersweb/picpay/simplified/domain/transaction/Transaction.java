package br.com.makersweb.picpay.simplified.domain.transaction;

import br.com.makersweb.picpay.simplified.domain.AggregateRoot;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aaristides
 */
public class Transaction extends AggregateRoot<TransactionID> {

    private BigDecimal amount;
    private User sender;
    private User receiver;
    private Instant createdAt;
    private Instant updatedAt;

    private Transaction(final TransactionID anId, final BigDecimal aAmount, final User aSender, final User aReceiver, final Instant aCreatedAt, final Instant aUpdatedAt) {
        super(anId);
        this.amount = aAmount;
        this.sender = aSender;
        this.receiver = aReceiver;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
    }

    public static Transaction newTransaction(final BigDecimal aAmount, final User aSender, final User aReceiver) {
        final var id = TransactionID.unique();
        final var now = Instant.now();
        return new Transaction(id, aAmount, aSender, aReceiver, now, now);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new TransactionValidator(this, handler).validate();
    }

    public Transaction update(final BigDecimal aAmount, final User aSender, final User aReceiver) {
        this.amount = aAmount;
        this.sender = aSender;
        this.receiver = aReceiver;
        this.updatedAt = Instant.now();
        return this;
    }

    public TransactionID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
