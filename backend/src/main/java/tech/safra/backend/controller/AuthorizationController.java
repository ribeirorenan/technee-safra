package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.AccountDto;
import tech.safra.backend.dto.AuthorizationDto;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.AccountService;
import tech.safra.backend.service.AuthorizationService;
import tech.safra.backend.service.ConsumerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/consumer/{consumerId}/authorization")
public class AuthorizationController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AuthorizationDto create(@PathVariable("consumerId") Long consumerId, @RequestBody AuthorizationDto authorizationDto) {
        Consumer consumer = consumerService.getById(consumerId);
        Authorization authorization  = convertToEntity(authorizationDto);
        authorization.setConsumer(consumer);
        return convertToDto(authorizationService.create(authorization));
    }

    @GetMapping
    @ResponseBody
    public List<AuthorizationDto> getAuthorizations(@PathVariable("consumerId") Long consumerId) {
        Consumer consumer = consumerService.getById(consumerId);
        List<Authorization> authorizations = consumer.getAuthorizations();
        return authorizations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{authorizationId}")
    public AuthorizationDto getAuthorization(@PathVariable("consumerId") Long consumerId, @PathVariable("authorizationId") Long authorizationId) {
        Consumer consumer = consumerService.getById(consumerId);
        Authorization authorization = authorizationService.getByConsumerAndId(consumer, authorizationId);
        return convertToDto(authorization);
    }

    @DeleteMapping("/{authorizationId}")
    public HttpStatus deleteAuthorization(@PathVariable("consumerId") Long consumerId, @PathVariable("authorizationId") Long authorizationId) {
        try {
            Consumer consumer = consumerService.getById(consumerId);
            Authorization authorization = authorizationService.getByConsumerAndId(consumer, authorizationId);
            authorizationService.deleteById(authorization.getId());
            return HttpStatus.OK;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Authorization not found", null);
        }
    }

    @PutMapping("/{authorizationId}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorizationDto updateAuthorization(@PathVariable("consumerId") Long consumerId, @PathVariable("authorizationId") Long authorizationId, @RequestBody AuthorizationDto authorizationDto) {
        Consumer consumer = consumerService.getById(consumerId);
        Authorization authorization = authorizationService.getByConsumerAndId(consumer, authorizationId);
        Authorization updateAuthorization = authorizationService.updateAuthorization(authorization.getId(), convertToEntity(authorizationDto));
        return convertToDto(updateAuthorization);
    }


    private AuthorizationDto convertToDto(Authorization authorization) {
        return  modelMapper.map(authorization, AuthorizationDto.class);
    }

    private Authorization convertToEntity(AuthorizationDto authorizationDto) {
        return modelMapper.map(authorizationDto, Authorization.class);
    }

}
