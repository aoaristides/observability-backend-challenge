package br.com.makersweb.picpay.simplified.infrastructure.user.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author aaristides
 */
public interface UserRepository extends JpaRepository<UserJpaEntity, String> {

    Page<UserJpaEntity> findAll(Specification<UserJpaEntity> whereClause, Pageable page);

    @Query(value = "select c.id from Users c where c.id in :ids")
    List<String> existsByIds(@Param("ids") List<String> ids);

}
