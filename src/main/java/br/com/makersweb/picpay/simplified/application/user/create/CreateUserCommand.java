package br.com.makersweb.picpay.simplified.application.user.create;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param firstName
 * @param lastName
 * @param document
 * @param mail
 * @param password
 * @param balance
 * @param type
 * @param isActive
 */
public record CreateUserCommand(
        String firstName,
        String lastName,
        String document,
        String mail,
        String password,
        BigDecimal balance,
        String type,
        boolean isActive
) {

    public static CreateUserCommand with(
            final String aFirstName,
            final String aLastName,
            final String aDocument,
            final String aMail,
            final String aPassword,
            final BigDecimal aBalance,
            final String aType,
            final boolean isActive
    ) {
        return new CreateUserCommand(aFirstName, aLastName, aDocument, aMail, aPassword, aBalance, aType, isActive);
    }

}
