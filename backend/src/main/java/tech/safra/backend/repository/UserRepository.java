package tech.safra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.safra.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
