package br.com.makersweb.picpay.simplified.domain.adapters.services.converter;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.CreateUserCommand;
import br.com.makersweb.picpay.simplified.domain.dto.UserDTO;
import lombok.experimental.UtilityClass;

/**
 * @author aaristides
 */
@UtilityClass
public class UserApiConverter {

    public static CreateUserCommand toCreateCommand(final UserDTO user) {
        return CreateUserCommand.with(user.firstName(), user.lastName(), user.document(), user.mail(), user.password(), user.balance(), user.type(), true);
    }

}
