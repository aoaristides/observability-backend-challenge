package br.com.makersweb.picpay.simplified.infrastructure.api.controllers;

import br.com.makersweb.picpay.simplified.application.user.create.CreateUserCommand;
import br.com.makersweb.picpay.simplified.application.user.create.CreateUserOutput;
import br.com.makersweb.picpay.simplified.application.user.create.CreateUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.delete.DeleteUserUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.get.GetUserByIdUseCase;
import br.com.makersweb.picpay.simplified.application.user.retrieve.list.ListUsersUseCase;
import br.com.makersweb.picpay.simplified.application.user.update.UpdateUserCommand;
import br.com.makersweb.picpay.simplified.application.user.update.UpdateUserOutput;
import br.com.makersweb.picpay.simplified.application.user.update.UpdateUserUseCase;
import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;
import br.com.makersweb.picpay.simplified.domain.validation.handler.Notification;
import br.com.makersweb.picpay.simplified.infrastructure.api.UserAPI;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.CreateUserRequest;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.UpdateUserRequest;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.UserListResponse;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.UserResponse;
import br.com.makersweb.picpay.simplified.infrastructure.user.presenters.UserApiPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author aaristides
 */
@RestController
public class UserController implements UserAPI {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final ListUsersUseCase listUsersUseCase;

    public UserController(
            final CreateUserUseCase createUserUseCase,
            final GetUserByIdUseCase getUserByIdUseCase,
            final UpdateUserUseCase updateUserUseCase,
            final DeleteUserUseCase deleteUserUseCase,
            final ListUsersUseCase listUsersUseCase) {
        this.createUserUseCase = Objects.requireNonNull(createUserUseCase);
        this.getUserByIdUseCase = Objects.requireNonNull(getUserByIdUseCase);
        this.updateUserUseCase = Objects.requireNonNull(updateUserUseCase);
        this.deleteUserUseCase = Objects.requireNonNull(deleteUserUseCase);
        this.listUsersUseCase = Objects.requireNonNull(listUsersUseCase);
    }

    @Override
    public ResponseEntity<?> createUser(final CreateUserRequest input) {
        final var aCommand = CreateUserCommand.with(
                input.firstName(),
                input.lastName(),
                input.document(),
                input.mail(),
                input.password(),
                input.balance(),
                input.type(),
                input.active() != null ? input.active() : true
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateUserOutput, ResponseEntity<?>> onSuccess = output ->
                ResponseEntity.created(URI.create("/users/" + output.id())).body(output);

        return this.createUserUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public Pagination<UserListResponse> listCategories(
            final String search,
            final int page,
            final int perPage,
            final String sort,
            final String direction
    ) {
        return listUsersUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(UserApiPresenter::present);
    }

    @Override
    public UserResponse getById(final String id) {
        return UserApiPresenter.present(this.getUserByIdUseCase.execute(id));
    }

    @Override
    public ResponseEntity<?> updateById(final String id, final UpdateUserRequest input) {
        final var aCommand = UpdateUserCommand.with(
                id,
                input.firstName(),
                input.lastName(),
                input.document(),
                input.mail(),
                input.password(),
                input.balance(),
                input.type(),
                input.active() != null ? input.active() : true
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateUserOutput, ResponseEntity<?>> onSuccess = ResponseEntity::ok;

        return this.updateUserUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public void deleteById(final String anId) {
        this.deleteUserUseCase.execute(anId);
    }
}
