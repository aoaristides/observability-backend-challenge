package br.com.makersweb.picpay.simplified.infrastructure.adapters.repositories;

import br.com.makersweb.picpay.simplified.infrastructure.adapters.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findUserByDocument(final String document);

}
