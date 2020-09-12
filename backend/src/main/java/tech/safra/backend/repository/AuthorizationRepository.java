package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Consumer;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
    List<Authorization> findAllByConsumer(Consumer consumer);
    Optional<Authorization> findByConsumerAndId(Consumer consumer, Long id);
}
