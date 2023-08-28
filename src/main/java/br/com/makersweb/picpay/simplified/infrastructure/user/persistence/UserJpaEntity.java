package br.com.makersweb.picpay.simplified.infrastructure.user.persistence;

import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserID;
import br.com.makersweb.picpay.simplified.domain.user.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aaristides
 */
@Entity(name = "Users")
@Table(name = "users")
@Getter
@Setter
public class UserJpaEntity {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String mail;

    private String password;
    private BigDecimal balance;
    private UserType type;
    private boolean active;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant updatedAt;

    @Column(name = "deleted_at", columnDefinition = "DATETIME(6)")
    private Instant deletedAt;

    public UserJpaEntity() {
    }

    public UserJpaEntity(
            String id,
            String firstName,
            String lastName,
            String document,
            String mail,
            String password,
            BigDecimal balance,
            UserType type,
            boolean active,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.mail = mail;
        this.password = password;
        this.balance = balance;
        this.type = type;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static UserJpaEntity from(final User aUser) {
        return new UserJpaEntity(
                aUser.getId().getValue(),
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

    public User toAggregate() {
        return User.with(
                UserID.from(getId()),
                getFirstName(),
                getLastName(),
                getDocument(),
                getMail(),
                getPassword(),
                getBalance(),
                getType(),
                isActive(),
                getCreatedAt(),
                getUpdatedAt(),
                getDeletedAt()
        );
    }

}
