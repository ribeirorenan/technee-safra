package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

}
