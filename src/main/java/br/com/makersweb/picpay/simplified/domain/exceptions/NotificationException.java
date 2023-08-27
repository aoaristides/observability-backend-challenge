package br.com.makersweb.picpay.simplified.domain.exceptions;

import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;

/**
 * @author aaristides
 */
public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }

}
