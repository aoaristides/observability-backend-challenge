package br.com.makersweb.picpay.simplified.domain.adapters.services.converter;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.CreateUserCommand;
import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.UpdateServiceUserCommand;
import br.com.makersweb.picpay.simplified.domain.ports.command.user.InsertUserCommand;
import br.com.makersweb.picpay.simplified.domain.ports.command.user.UpdateUserCommand;
import lombok.experimental.UtilityClass;

/**
 * @author aaristides
 */
@UtilityClass
public class UserServiceConverter {

    public static InsertUserCommand toInsertCommand(final CreateUserCommand command) {
        return InsertUserCommand.with(command.aFirstName(), command.aLastName(), command.aDocument(), command.aMail(), command.aPassword(), command.aBalance(), command.aType(), command.isActive());
    }

    public static UpdateUserCommand toUpdateCommand(final UpdateServiceUserCommand command) {
        return UpdateUserCommand.with(command.id(), command.aFirstName(), command.aLastName(), command.aDocument(), command.aMail(), command.aPassword(), command.aBalance(), command.aType(), command.isActive());
    }

}
