package br.com.makersweb.picpay.simplified.application.user.update;

import br.com.makersweb.picpay.simplified.domain.user.User;

/**
 * @author aaristides
 * @param id
 */
public record UpdateUserOutput(
        String id
) {

    public static UpdateUserOutput from(final String anId) {
        return new UpdateUserOutput(anId);
    }

    public static UpdateUserOutput from(final User aUser) {
        return new UpdateUserOutput(aUser.getId().getValue());
    }

}
