package br.com.makersweb.picpay.simplified.domain.ports.interfaces;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.CreateUserCommand;
import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.UpdateServiceUserCommand;
import br.com.makersweb.picpay.simplified.domain.dto.UserDTO;
import br.com.makersweb.picpay.simplified.domain.user.User;

import java.util.List;

/**
 * @author aaristides
 */
public interface UserServicePort {

    List<UserDTO> findUsers();

    UserDTO findById(final String id);

    UserDTO findByDocument(final String document);

    User createUser(final CreateUserCommand createUserCommand);

    void updateUser(final UpdateServiceUserCommand updateUserCommand);

}
