package br.com.makersweb.picpay.simplified.infrastructure.user.presenters;

import br.com.makersweb.picpay.simplified.application.user.retrieve.get.UserOutput;
import br.com.makersweb.picpay.simplified.application.user.retrieve.list.UserListOutput;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.UserListResponse;
import br.com.makersweb.picpay.simplified.infrastructure.user.models.UserResponse;

/**
 * @author aaristides
 */
public interface UserApiPresenter {

    static UserResponse present(final UserOutput output) {
        return new UserResponse(
                output.id().getValue(),
                output.firstName(),
                output.lastName(),
                output.document(),
                output.mail(),
                output.password(),
                output.balance(),
                output.type(),
                output.isActive(),
                output.createdAt(),
                output.updatedAt(),
                output.deletedAt()
        );
    }

    static UserListResponse present(final UserListOutput output) {
        return new UserListResponse(
                output.id().getValue(),
                output.firstName(),
                output.lastName(),
                output.document(),
                output.mail(),
                output.password(),
                output.balance(),
                output.type(),
                output.isActive(),
                output.createdAt(),
                output.deletedAt()
        );
    }

}
