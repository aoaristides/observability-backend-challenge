package br.com.makersweb.picpay.simplified.infrastructure.user.models;

import br.com.makersweb.picpay.simplified.domain.user.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aaristides
 * @param firstName
 * @param lastName
 * @param document
 * @param mail
 * @param password
 * @param balance
 * @param type
 * @param active
 * @param createdAt
 * @param updatedAt
 * @param deletedAt
 */
public record UserResponse(
        @JsonProperty("id") String id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("document") String document,
        @JsonProperty("mail") String mail,
        @JsonProperty("password") String password,
        @JsonProperty("balance") BigDecimal balance,
        @JsonProperty("type") UserType type,
        @JsonProperty("is_active") Boolean active,
        @JsonProperty("created_at") Instant createdAt,
        @JsonProperty("updated_at") Instant updatedAt,
        @JsonProperty("deleted_at") Instant deletedAt
) {
}
