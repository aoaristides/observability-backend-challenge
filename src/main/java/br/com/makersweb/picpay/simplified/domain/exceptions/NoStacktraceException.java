package br.com.makersweb.picpay.simplified.domain.exceptions;

/**
 * @author aaristides
 */
public class NoStacktraceException extends RuntimeException {

    public NoStacktraceException(String message) {
        this(message, null);
    }

    public NoStacktraceException(String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
