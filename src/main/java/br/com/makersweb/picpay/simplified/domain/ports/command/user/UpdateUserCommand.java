package br.com.makersweb.picpay.simplified.domain.ports.command.user;

import br.com.makersweb.picpay.simplified.domain.user.UserType;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param aFirstName
 * @param aLastName
 * @param aDocument
 * @param aMail
 * @param aPassword
 * @param aBalance
 * @param aType
 * @param isActive
 */
public record UpdateUserCommand(String id, String aFirstName, String aLastName, String aDocument, String aMail, String aPassword, BigDecimal aBalance, UserType aType, boolean isActive) {

    public static UpdateUserCommand with(final String id, final String aFirstName, final String aLastName, final String aDocument, final String aMail, final String aPassword, final BigDecimal aBalance, final UserType aType, final boolean isActive) {
        return new UpdateUserCommand(id, aFirstName, aLastName, aDocument, aMail, aPassword, aBalance, aType, isActive);
    }

}
