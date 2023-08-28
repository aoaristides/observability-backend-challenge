package br.com.makersweb.picpay.simplified.application.user.update;

import br.com.makersweb.picpay.simplified.domain.user.UserType;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param id
 * @param firstName
 * @param lastName
 * @param document
 * @param mail
 * @param password
 * @param balance
 * @param type
 * @param isActive
 */
public record UpdateUserCommand(
        String id,
        String firstName,
        String lastName,
        String document,
        String mail,
        String password,
        BigDecimal balance,
        UserType type,
        boolean isActive
) {

    public static UpdateUserCommand with(
            final String anId,
            final String aFirstName,
            final String aLastName,
            final String aDocument,
            final String aMail,
            final String aPassword,
            final BigDecimal aBalance,
            final UserType aType,
            final boolean isActive
    ) {
        return new UpdateUserCommand(anId, aFirstName, aLastName, aDocument, aMail, aPassword, aBalance, aType, isActive);
    }

}
