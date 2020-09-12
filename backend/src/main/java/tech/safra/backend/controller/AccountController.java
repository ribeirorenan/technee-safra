package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.AccountDto;
import tech.safra.backend.dto.ConsumerDto;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.AccountService;
import tech.safra.backend.service.ConsumerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/consumer/{consumerId}/account")
public class AccountController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountService accountService;

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AccountDto create(@PathVariable("consumerId") Long consumerId, @RequestBody AccountDto accountDto) {
        Consumer consumer = consumerService.getById(consumerId);
        Account account  = convertToEntity(accountDto);
        account.setConsumer(consumer);
        return convertToDto(accountService.create(account));
    }

    @GetMapping
    @ResponseBody
    public List<AccountDto> getAccounts(@PathVariable("consumerId") Long consumerId) {
        Consumer consumer = consumerService.getById(consumerId);
        List<Account> accounts = consumer.getAccounts();
        return accounts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{accountId}")
    public AccountDto getAccount(@PathVariable("consumerId") Long consumerId, @PathVariable("accountId") Long accountId) {
        Consumer consumer = consumerService.getById(consumerId);
        Account account = accountService.getByConsumerAndId(consumer, accountId);
        return convertToDto(account);
    }

    @DeleteMapping("/{accountId}")
    public HttpStatus deleteAccount(@PathVariable("consumerId") Long consumerId, @PathVariable("accountId") Long accountId) {
        try {
            Consumer consumer = consumerService.getById(consumerId);
            Account account = accountService.getByConsumerAndId(consumer, accountId);
            accountService.deleteById(account.getId());
            return HttpStatus.OK;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Account not found", null);
        }
    }

    @PutMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto updateAccount(@PathVariable("consumerId") Long consumerId, @PathVariable("accountId") Long accountId, @RequestBody AccountDto accountDto) {
        Consumer consumer = consumerService.getById(consumerId);
        Account account = accountService.getByConsumerAndId(consumer, accountId);
        Account updateAccount = accountService.updateAccount(account.getId(), convertToEntity(accountDto));
        return convertToDto(updateAccount);
    }


    private AccountDto convertToDto(Account account) {
        return  modelMapper.map(account, AccountDto.class);
    }

    private Account convertToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

}
