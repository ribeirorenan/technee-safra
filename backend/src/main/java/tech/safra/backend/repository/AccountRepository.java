package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Consumer;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByConsumer(Consumer consumer);
    Optional<Account> findByConsumerAndId(Consumer consumer, Long id);
}
