package br.com.makersweb.picpay.simplified.domain.transaction;

import br.com.makersweb.picpay.simplified.domain.AggregateRoot;
import br.com.makersweb.picpay.simplified.domain.exceptions.NotificationException;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.utils.InstantUtils;
import br.com.makersweb.picpay.simplified.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;

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

    private Transaction(
            final TransactionID anId,
            final BigDecimal aAmount,
            final User aSender,
            final User aReceiver,
            final Instant aCreatedAt,
            final Instant aUpdatedAt
    ) {
        super(anId);
        this.amount = aAmount;
        this.sender = aSender;
        this.receiver = aReceiver;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
        selfValidate();
    }

    public static Transaction newTransaction(final BigDecimal aAmount, final User aSender, final User aReceiver) {
        final var id = TransactionID.unique();
        final var now = Instant.now();
        return new Transaction(id, aAmount, aSender, aReceiver, now, now);
    }

    public static Transaction with(
            final TransactionID anId,
            final BigDecimal aAmount,
            final User aSender,
            final User aReceiver,
            final Instant aCreatedAt,
            final Instant aUpdatedAt
    ) {
        return new Transaction(anId, aAmount, aSender, aReceiver, aCreatedAt, aUpdatedAt);
    }

    public static Transaction with(final Transaction aTransaction) {
        return new Transaction(
                aTransaction.getId(),
                aTransaction.amount,
                aTransaction.sender,
                aTransaction.receiver,
                aTransaction.createdAt,
                aTransaction.updatedAt
        );
    }

    @Override
    public void validate(ValidationHandler handler) {
        new TransactionValidator(this, handler).validate();
    }

    public Transaction update(final BigDecimal aAmount, final User aSender, final User aReceiver) {
        this.amount = aAmount;
        this.sender = aSender;
        this.receiver = aReceiver;
        this.updatedAt = InstantUtils.now();
        selfValidate();
        return this;
    }

    private void selfValidate() {
        final var notification = Notification.create();
        validate(notification);

        if (notification.hasError()) {
            throw new NotificationException("Failed to create a Aggregate Transaction", notification);
        }
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
