package br.com.makersweb.picpay.simplified.domain.user;

import br.com.makersweb.picpay.simplified.domain.exceptions.DomainException;
import br.com.makersweb.picpay.simplified.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
public class UserTest {

    @Test
    public void givenAValidParams_whenCallNewUser_thenInstantiateAUser() {
        final var expectedFirstName = "Joyce";
        final var expectedLastName = "Miranda";
        final var expectedDocument = "123.456.789-09";
        final var expectedMail = "joyce.miranda@example.com";
        final var expectedPassword = "Tulipa123@";
        final var expectedBalance = BigDecimal.valueOf(10);
        final var expectedType = UserType.COMMON;
        final var expectedActive = true;

        final var actualUser = User.newUser(expectedFirstName, expectedLastName, expectedDocument, expectedMail, expectedPassword, expectedBalance, expectedType, expectedActive);

        Assertions.assertNotNull(actualUser);
        Assertions.assertNotNull(actualUser.getId());
        Assertions.assertEquals(expectedFirstName, actualUser.getFirstName());
        Assertions.assertEquals(expectedLastName, actualUser.getLastName());
        Assertions.assertEquals(expectedDocument, actualUser.getDocument());
        Assertions.assertEquals(expectedActive, actualUser.isActive());
        Assertions.assertNotNull(actualUser.getCreatedAt());
        Assertions.assertNotNull(actualUser.getUpdatedAt());
        Assertions.assertNull(actualUser.getDeletedAt());
    }

    @Test
    public void givenAnInvalidNullFirstName_whenCallNewUserAndValidate_thenShouldReceiveError() {
        final String expectedFirstName = null;
        final var expectedLastName = "Miranda";
        final var expectedDocument = "123.456.789-09";
        final var expectedMail = "joyce.miranda@example.com";
        final var expectedPassword = "Tulipa123@";
        final var expectedBalance = BigDecimal.valueOf(10);
        final var expectedType = UserType.COMMON;
        final var expectedActive = true;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'firstName' or 'lastName' should not be null";

        final var actualUser = User.newUser(expectedFirstName, expectedLastName, expectedDocument, expectedMail, expectedPassword, expectedBalance, expectedType, expectedActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualUser.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
}
