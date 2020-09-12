package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

}
