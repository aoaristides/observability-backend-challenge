package br.com.makersweb.picpay.simplified.application.user.create;

import br.com.makersweb.picpay.simplified.domain.user.User;

/**
 * @author aaristides
 * @param id
 */
public record CreateUserOutput(
        String id
) {

    public static CreateUserOutput from(final String anId) {
        return new CreateUserOutput(anId);
    }

    public static CreateUserOutput from(final User aUser) {
        return new CreateUserOutput(aUser.getId().getValue());
    }

}
