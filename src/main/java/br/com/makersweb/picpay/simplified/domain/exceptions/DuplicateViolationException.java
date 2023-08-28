package br.com.makersweb.picpay.simplified.domain.exceptions;


import br.com.makersweb.picpay.simplified.domain.AggregateRoot;
import br.com.makersweb.picpay.simplified.domain.validation.Error;

import java.util.Collections;
import java.util.List;

/**
 * @author aaristides
 */
public class DuplicateViolationException extends DomainException {

    protected DuplicateViolationException(final String aMessage, final List<Error> anErrors) {
        super(aMessage, anErrors);
    }

    public static DuplicateViolationException with(final Class<? extends AggregateRoot<?>> anAggregate, final String field) {
        final var anError = "%s com document %s já cadastrado.".formatted(anAggregate.getSimpleName(), field);
        return new DuplicateViolationException(anError, Collections.singletonList(new Error(anError)));
    }

}
