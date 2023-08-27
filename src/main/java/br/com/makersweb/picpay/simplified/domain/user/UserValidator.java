package br.com.makersweb.picpay.simplified.domain.user;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.makersweb.picpay.simplified.domain.validation.Error;
import br.com.makersweb.picpay.simplified.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.simplified.domain.validation.Validator;

/**
 * @author aaristides
 */
public class UserValidator extends Validator {

    private final User user;
    private static final int NAME_MAX_LENGTH = 255;
    private static final int NAME_MIN_LENGTH = 3;
    private static final int CPF_LENGTH = 11;
    private static final int CNPJ_LENGTH = 14;

    public UserValidator(final User aUser, final ValidationHandler aHandler) {
        super(aHandler);
        this.user = aUser;
    }

    @Override
    public void validate() {
        checkFirstNameOrLastNameConstraints();
        checkDocument();
    }

    private void checkFirstNameOrLastNameConstraints() {
        final var firstName = this.user.getFirstName();
        final var lastName = this.user.getLastName();
        if (firstName == null || lastName == null) {
            this.validationHandler().append(new Error("'firstName' or 'lastName' should not be null"));
            return;
        }

        if (firstName.isBlank() || lastName.isBlank()) {
            this.validationHandler().append(new Error("'firstName' or 'lastName' should not be empty"));
            return;
        }

        final var lengthFirstName = firstName.trim().length();
        final var lengthLastName = lastName.trim().length();
        final boolean isMaxOrMinLengthFirstName = lengthFirstName > NAME_MAX_LENGTH || lengthFirstName < NAME_MIN_LENGTH;
        final boolean isMaxOrMinLengthLastName = lengthLastName > NAME_MAX_LENGTH || lengthLastName < NAME_MIN_LENGTH;
        if (isMaxOrMinLengthFirstName || isMaxOrMinLengthLastName) {
            this.validationHandler().append(new Error("'firstName' or 'lastName' must be between 3 and 255 characters"));
        }
    }

    private void checkDocument() {
        final var document = this.user.getDocument().trim();
        if (document == null) {
            this.validationHandler().append(new Error("'document' should not be null"));
            return;
        }

        final var length = document.length();
        if (length == CPF_LENGTH) {
            try {
                final var cpfValidator = new CPFValidator();
                cpfValidator.assertValid(document);
            } catch (Exception e) {
                this.validationHandler().append(new Error("'document' CPF invalid."));
                return;
            }
        }

        if (length == CNPJ_LENGTH) {
            try {
                final var cnpjValidator = new CNPJValidator();
                cnpjValidator.assertValid(document);
            } catch (Exception e) {
                this.validationHandler().append(new Error("'document' CNPJ invalid."));
            }
        }
    }

}
