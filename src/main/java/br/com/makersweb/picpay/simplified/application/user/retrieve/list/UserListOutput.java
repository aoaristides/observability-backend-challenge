package br.com.makersweb.picpay.simplified.application.user.retrieve.list;

import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserID;
import br.com.makersweb.picpay.simplified.domain.user.UserType;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aaristides
 * @param id
 * @param firstName
 * @param lastName
 * @param document
 * @param mail
 * @param password
 * @param balance
 * @param type
 * @param isActive
 * @param createdAt
 * @param updatedAt
 * @param deletedAt
 */
public record UserListOutput(
        UserID id,
        String firstName,
        String lastName,
        String document,
        String mail,
        String password,
        BigDecimal balance,
        UserType type,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) {

    public static UserListOutput from(final User aUser) {
        return new UserListOutput(
                aUser.getId(),
                aUser.getFirstName(),
                aUser.getLastName(),
                aUser.getDocument(),
                aUser.getMail(),
                aUser.getPassword(),
                aUser.getBalance(),
                aUser.getType(),
                aUser.isActive(),
                aUser.getCreatedAt(),
                aUser.getUpdatedAt(),
                aUser.getDeletedAt()
        );
    }

}
