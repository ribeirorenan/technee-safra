package tech.safra.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.repository.AccountRepository;
import tech.safra.backend.repository.AuthorizationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    AuthorizationRepository authorizationRepository;

    @Transactional
    public Authorization create(Authorization authorization) {
        return authorizationRepository.save(authorization);
    }

    public List<Authorization> getAll() {
        return authorizationRepository.findAll();
    }

    public Authorization getById(Long id) {
        return authorizationRepository.findById(id).orElseThrow(() -> new NotFoundException("Authorization not found", null));
    }

    public List<Authorization> getAllByConsumer(Consumer consumer) {
        return authorizationRepository.findAllByConsumer(consumer);
    }

    public Authorization getByConsumerAndId(Consumer consumer, Long id) {
        return authorizationRepository.findByConsumerAndId(consumer, id).orElseThrow(() -> new NotFoundException("Authorization not found", null));
    }

    public void deleteById(Long id) {
        authorizationRepository.deleteById(id);
    }

    public Authorization updateAuthorization(Long id, Authorization newAuthorization) {
        return authorizationRepository.findById(id).map(authorization -> {
            //authorization.setFirstName(newAuthorization.getFirstName());
            return authorizationRepository.save(authorization);
        }).orElseThrow(() -> new NotFoundException("Authorization Not found", null));
    }
}
