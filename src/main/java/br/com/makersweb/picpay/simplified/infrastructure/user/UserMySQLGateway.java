package br.com.makersweb.picpay.simplified.infrastructure.user;

import br.com.makersweb.picpay.simplified.domain.exceptions.DuplicateViolationException;
import br.com.makersweb.picpay.simplified.domain.pagination.Pagination;
import br.com.makersweb.picpay.simplified.domain.pagination.SearchQuery;
import br.com.makersweb.picpay.simplified.domain.user.User;
import br.com.makersweb.picpay.simplified.domain.user.UserGateway;
import br.com.makersweb.picpay.simplified.domain.user.UserID;
import br.com.makersweb.picpay.simplified.infrastructure.user.persistence.UserJpaEntity;
import br.com.makersweb.picpay.simplified.infrastructure.user.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static br.com.makersweb.picpay.simplified.infrastructure.utils.SpecificationUtils.like;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class UserMySQLGateway implements UserGateway {

    private final UserRepository repository;

    public UserMySQLGateway(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(final User aUser) {
        log.info("Init method create by user - {}", aUser.getId());
        final var existUserByDocument = this.findByDocument(aUser.getDocument());
        if (existUserByDocument.isPresent()) {
            throw DuplicateViolationException.with(User.class, aUser.getDocument());
        }

        return save(aUser);
    }

    @Override
    public void deleteById(final UserID anId) {
        final String anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }
    }

    @Override
    public Optional<User> findById(final UserID anId) {
        return this.repository.findById(anId.getValue()).map(UserJpaEntity::toAggregate);
    }

    @Override
    public Optional<User> findByDocument(final String aDocument) {
        log.info("Init method findByDocument by document - {}", aDocument);
        return this.repository.findByDocument(aDocument).map(UserJpaEntity::toAggregate);
    }

    @Override
    public User update(final User aUser) {
        return save(aUser);
    }

    @Override
    public Pagination<User> findAll(final SearchQuery aQuery) {
        // Paginação
        final var page = PageRequest.of(
                aQuery.page(),
                aQuery.perPage(),
                Sort.by(Sort.Direction.fromString(aQuery.direction()), aQuery.sort())
        );

        // Busca dinamica pelo criterio terms (name ou description)
        final var specifications = Optional.ofNullable(aQuery.terms())
                .filter(str -> !str.isBlank())
                .map(this::assembleSpecification)
                .orElse(null);

        final var pageResult = this.repository.findAll(Specification.where(specifications), page);

        if (pageResult.getTotalElements() == 0) {
            return new Pagination<>(0, 0, 0,  Collections.emptyList());
        }

        return new Pagination<>(
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.map(UserJpaEntity::toAggregate).toList()
        );
    }

    @Override
    public List<UserID> existsByIds(final Iterable<UserID> ids) {
        return null;
    }

    private User save(final User aUser) {
        return this.repository.save(UserJpaEntity.from(aUser)).toAggregate();
    }

    private Specification<UserJpaEntity> assembleSpecification(final String str) {
        final Specification<UserJpaEntity> firstNameLike = like("firstName", str);
        final Specification<UserJpaEntity> lastNameLike = like("lastName", str);
        return firstNameLike.or(lastNameLike);
    }
}
