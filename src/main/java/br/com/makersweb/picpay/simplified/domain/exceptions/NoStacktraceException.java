package br.com.makersweb.picpay.simplified.domain.exceptions;

/**
 * @author aaristides
 */
public class NoStacktraceException extends RuntimeException {

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(final String message, final Throwable cause) {
        super(message, cause, true, false);
    }

}
