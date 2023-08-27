package br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories;

import br.com.makersweb.picpay.simplified.infrastructure.adapters.entity.transaction.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author aaristides
 */
public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {
}
