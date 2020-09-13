package tech.safra.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.repository.AccountRepository;
import tech.safra.backend.repository.ConsumerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found", null));
    }

    public List<Account> getAllByConsumer(Consumer consumer) {
        return accountRepository.findAllByConsumer(consumer);
    }

    public Account getByConsumerAndId(Consumer consumer, Long id) {
        return accountRepository.findByConsumerAndId(consumer, id).orElseThrow(() -> new NotFoundException("Account not found", null));
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Long id, Account newAccount) {
        return accountRepository.findById(id).map(account -> {
            //account.setFirstName(newAccount.getFirstName());
            return accountRepository.save(account);
        }).orElseThrow(() -> new NotFoundException("Account Not found", null));
    }
}
