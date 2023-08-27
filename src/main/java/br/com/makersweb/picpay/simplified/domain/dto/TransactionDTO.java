package br.com.makersweb.picpay.simplified.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param value
 * @param senderId
 * @param receiverId
 */
public record TransactionDTO(@JsonProperty("value") BigDecimal value, @JsonProperty("sender_id") String senderId, @JsonProperty("receiver_id") String receiverId) {
}
