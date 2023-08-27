package br.com.makersweb.picpay.simplified.domain.adapters.services.command.user;

import br.com.makersweb.picpay.simplified.domain.user.UserType;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param id
 * @param aFirstName
 * @param aLastName
 * @param aDocument
 * @param aMail
 * @param aPassword
 * @param aBalance
 * @param aType
 * @param isActive
 */
public record UpdateServiceUserCommand(String id, String aFirstName, String aLastName, String aDocument, String aMail, String aPassword, BigDecimal aBalance, UserType aType, boolean isActive) {

    public static UpdateServiceUserCommand with(final String id, final String aFirstName, final String aLastName, final String aDocument, final String aMail, final String aPassword, final BigDecimal aBalance, final UserType aType, final boolean isActive) {
        return new UpdateServiceUserCommand(id, aFirstName, aLastName, aDocument, aMail, aPassword, aBalance, aType, isActive);
    }

}
