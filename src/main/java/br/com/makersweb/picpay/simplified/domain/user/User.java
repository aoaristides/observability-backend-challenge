package br.com.makersweb.picpay.simplified.domain.user;

import br.com.makersweb.picpay.simplified.domain.AggregateRoot;
import br.com.makersweb.picpay.simplified.domain.utils.InstantUtils;
import br.com.makersweb.picpay.simplified.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * @author aaristides
 */
public class User extends AggregateRoot<UserID> {

    private String firstName;
    private String lastName;
    private String document;
    private String mail;
    private String password;
    private BigDecimal balance;
    private UserType type;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(
            final UserID anId,
            final String aFirstName,
            final String aLastName,
            final String aDocument,
            final String aMail,
            final String aPassword,
            final BigDecimal aBalance,
            final UserType aType,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.document = aDocument;
        this.mail = aMail;
        this.password = aPassword;
        this.balance = aBalance;
        this.type = aType;
        this.active = isActive;
        this.createdAt = Objects.requireNonNull(aCreationDate, "'createdAt' should not be null");;
        this.updatedAt = Objects.requireNonNull(aUpdateDate, "'updatedAt' should not be null");;
        this.deletedAt = aDeleteDate;
    }

    public static User newUser(
            final String aFirstName,
            final String aLastName,
            final String aDocument,
            final String aMail,
            final String aPassword,
            final BigDecimal aBalance,
            final UserType aType,
            final boolean isActive
    ) {
        final var id = UserID.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;
        return new User(id, aFirstName, aLastName, aDocument, aMail, aPassword, aBalance, aType, isActive, now, now, deletedAt);
    }

    public static User with(
            final UserID anId,
            final String firstName,
            final String lastName,
            final String document,
            final String mail,
            final String password,
            final BigDecimal balance,
            final UserType type,
            final boolean isActive,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt

    ) {
        return new User(anId, firstName, lastName, document, mail, password, balance, type, isActive, createdAt, updatedAt, deletedAt);
    }

    public static User with(final User aUser) {
        return with(
                aUser.getId(),
                aUser.firstName,
                aUser.lastName,
                aUser.document,
                aUser.mail,
                aUser.password,
                aUser.balance,
                aUser.type,
                aUser.isActive(),
                aUser.createdAt,
                aUser.updatedAt,
                aUser.deletedAt
        );
    }

    @Override
    public void validate(ValidationHandler handler) {
        new UserValidator(this, handler).validate();
    }

    public User activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public User deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public User update(
            final String aFirstName,
            final String aLastName,
            final String aDocument,
            final String aMail,
            final String aPassword,
            final BigDecimal aBalance,
            final UserType aType,
            final boolean isActive
    ) {
        if (isActive) {
            activate();
        } else {
            deactivate();
        }

        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.document = aDocument;
        this.mail = aMail;
        this.password = aPassword;
        this.balance = aBalance;
        this.type = aType;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public UserID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public UserType getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

}
