package br.com.makersweb.picpay.simplified.domain.ports.repositories;

import br.com.makersweb.picpay.simplified.domain.ports.command.user.InsertUserCommand;
import br.com.makersweb.picpay.simplified.domain.ports.command.user.UpdateUserCommand;
import br.com.makersweb.picpay.simplified.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
public interface UserRepositoryPort {

    List<User> findAll();

    Optional<User> findById(final UUID id);

    Optional<User> findUserByDocument(final String document);

    User update(final UpdateUserCommand updateUserCommand);

    User save(final InsertUserCommand insertUserCommand);

    void delete(final UUID id);

}
