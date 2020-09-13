package tech.safra.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.repository.ConsumerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    @Transactional
    public Consumer create(Consumer user) {
        return consumerRepository.save(user);
    }

    public List<Consumer> getAll() {
        return consumerRepository.findAll();
    }

    public Consumer getById(Long id) {
        return consumerRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found", null));
    }

    public void deleteById(Long id) {
        consumerRepository.deleteById(id);
    }

    public Consumer updateConsumer(Long id, Consumer newConsumer) {
        return consumerRepository.findById(id).map(user -> {
            user.setFirstName(newConsumer.getFirstName());
            return consumerRepository.save(user);
        }).orElseThrow(() -> new NotFoundException("User Not found", null));
    }
}
