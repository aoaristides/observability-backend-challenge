package br.com.makersweb.picpay.simplified.infrastructure.user.models;

import br.com.makersweb.picpay.simplified.domain.user.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

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
 */
public record UpdateUserRequest(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("document") String document,
        @JsonProperty("mail") String mail,
        @JsonProperty("password") String password,
        @JsonProperty("balance") BigDecimal balance,
        @JsonProperty("type") UserType type,
        @JsonProperty("is_active") Boolean active
) {
}
