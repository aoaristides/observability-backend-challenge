package br.com.makersweb.picpay.simplified.domain.dto;

import br.com.makersweb.picpay.simplified.domain.user.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param firstName
 * @param lastName
 * @param document
 * @param balance
 * @param mail
 * @param password
 * @param type
 */
public record UserDTO(@JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName, @JsonProperty("document") String document, @JsonProperty("balance") BigDecimal balance, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("type") UserType type) {
}
