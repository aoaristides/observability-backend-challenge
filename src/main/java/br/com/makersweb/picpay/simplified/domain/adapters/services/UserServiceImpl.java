package br.com.makersweb.picpay.simplified.domain.adapters.services;

import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.CreateUserCommand;
import br.com.makersweb.picpay.simplified.domain.adapters.services.command.user.UpdateServiceUserCommand;
import br.com.makersweb.picpay.simplified.domain.adapters.services.converter.UserServiceConverter;
import br.com.makersweb.picpay.simplified.domain.dto.UserDTO;
import br.com.makersweb.picpay.simplified.domain.exceptions.DomainException;
import br.com.makersweb.picpay.simplified.domain.ports.interfaces.UserServicePort;
import br.com.makersweb.picpay.simplified.domain.ports.repositories.UserRepositoryPort;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.validation.Error;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<UserDTO> findUsers() {
        log.info("Init method findUsers.");
        final var users = this.userRepositoryPort.findAll();
        return CollectionUtils.isEmpty(users) ? Collections.emptyList() : users.stream().map(User::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(final String id) {
        log.info("Init method findById id - {}", id);
        final var user = this.userRepositoryPort.findById(UUID.fromString(id));
        if (!user.isPresent())
            throw DomainException.with(new Error("Usuário não encontrado"));
        return user.get().toUserDTO();
    }

    @Override
    public UserDTO findByDocument(final String document) {
        log.info("Init method findByDocument document - {}", document);
        final var user = this.userRepositoryPort.findUserByDocument(document);
        if (!user.isPresent())
            throw DomainException.with(new Error("Usuário não encontrado"));
        return user.get().toUserDTO();
    }

    @Override
    public User createUser(final CreateUserCommand createUserCommand) {
        log.info("Init method createUser by firstName - {}", createUserCommand.aFirstName());
        return this.userRepositoryPort.save(UserServiceConverter.toInsertCommand(createUserCommand));
    }

    @Override
    public void updateUser(final UpdateServiceUserCommand updateUserCommand) {
        log.info("Init method updateUser by id - {}", updateUserCommand.id());
        final var updateUser = this.userRepositoryPort.update(UserServiceConverter.toUpdateCommand(updateUserCommand));
        if (Objects.nonNull(updateUser)) {
            log.info("Usuário [{}] atualizado com sucesso.", updateUser.getId());
        }
    }
}
