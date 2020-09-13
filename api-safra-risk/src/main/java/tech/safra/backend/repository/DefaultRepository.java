package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.Default;
import tech.safra.backend.entity.Partner;

@Repository
public interface DefaultRepository extends JpaRepository<Default, Long> {

}
