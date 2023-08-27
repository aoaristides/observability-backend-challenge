package br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories.impl;

import br.com.makersweb.picpay.simplified.domain.ports.command.user.InsertUserCommand;
import br.com.makersweb.picpay.simplified.domain.ports.command.user.UpdateUserCommand;
import br.com.makersweb.picpay.simplified.domain.ports.repositories.UserRepositoryPort;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories.UserJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
@Component
@Slf4j
@AllArgsConstructor
public class UserRepository implements UserRepositoryPort {

    private final UserJpaRepository repository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(final UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByDocument(final String document) {
        return Optional.empty();
    }

    @Override
    public User update(final UpdateUserCommand updateUserCommand) {
        return null;
    }

    @Override
    public User save(final InsertUserCommand insertUserCommand) {
        return null;
    }

    @Override
    public void delete(final UUID id) {

    }
}
