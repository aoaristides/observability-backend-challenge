package br.com.makersweb.picpay.simplified.infrastructure.adapters.entity.user;

import br.com.makersweb.picpay.simplified.domain.user.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * @author aaristides
 */
@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String mail;
    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType type;

    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

}
