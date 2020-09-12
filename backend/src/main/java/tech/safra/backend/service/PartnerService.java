
package tech.safra.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.safra.backend.entity.Partner;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.repository.PartnerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    @Transactional
    public Partner create(Partner user) {
        return partnerRepository.save(user);
    }

    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }

    public Partner getById(Long id) {
        return partnerRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found", null));
    }

    public void deleteById(Long id) {
        partnerRepository.deleteById(id);
    }

    public Partner updatePartner(Long id, Partner newPartner) {
        return partnerRepository.findById(id).map(user -> {
            //user.setFirstName(newPartner.getFirstName());
            return partnerRepository.save(user);
        }).orElseThrow(() -> new NotFoundException("User Not found", null));
    }
}
