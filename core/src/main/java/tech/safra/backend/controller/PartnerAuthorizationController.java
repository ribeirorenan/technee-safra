package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.ConsumerAuthorizationDto;
import tech.safra.backend.dto.PartnerAuthorizationDto;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Partner;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.AuthorizationService;
import tech.safra.backend.service.PartnerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/partner/{partnerId}/authorization")
@CrossOrigin
public class PartnerAuthorizationController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    PartnerService partnerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PartnerAuthorizationDto create(@PathVariable("partnerId") Long partnerId, @RequestBody PartnerAuthorizationDto partnerAuthorizationDto) {
        Partner partner = partnerService.getById(partnerId);
        Authorization authorization  = convertToEntity(partnerAuthorizationDto);
        authorization.setPartner(partner);
        return convertToDto(authorizationService.create(authorization));
    }

    @GetMapping
    @ResponseBody
    public List<PartnerAuthorizationDto> getAuthorizations(@PathVariable("partnerId") Long partnerId) {
        Partner partner = partnerService.getById(partnerId);
        List<Authorization> authorizations = partner.getAuthorizations();
        return authorizations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{authorizationId}")
    public PartnerAuthorizationDto getAuthorization(@PathVariable("partnerId") Long partnerId, @PathVariable("authorizationId") Long authorizationId) {
        Partner partner = partnerService.getById(partnerId);
        Authorization authorization = authorizationService.getByPartnerAndId(partner, authorizationId);
        return convertToDto(authorization);
    }

    @DeleteMapping("/{authorizationId}")
    public HttpStatus deleteAuthorization(@PathVariable("partnerId") Long partnerId, @PathVariable("authorizationId") Long authorizationId) {
        try {
            Partner partner = partnerService.getById(partnerId);
            Authorization authorization = authorizationService.getByPartnerAndId(partner, authorizationId);
            authorizationService.deleteById(authorization.getId());
            return HttpStatus.OK;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Authorization not found", null);
        }
    }

    @PutMapping("/{authorizationId}")
    @ResponseStatus(HttpStatus.OK)
    public PartnerAuthorizationDto updateAuthorization(@PathVariable("partnerId") Long partnerId, @PathVariable("authorizationId") Long authorizationId, @RequestBody PartnerAuthorizationDto partnerAuthorizationDto) {
        Partner partner = partnerService.getById(partnerId);
        Authorization authorization = authorizationService.getByPartnerAndId(partner, authorizationId);
        Authorization updateAuthorization = authorizationService.updateAuthorization(authorization.getId(), convertToEntity(partnerAuthorizationDto));
        return convertToDto(updateAuthorization);
    }


    private PartnerAuthorizationDto convertToDto(Authorization authorization) {
        return  modelMapper.map(authorization, PartnerAuthorizationDto.class);
    }

    private Authorization convertToEntity(PartnerAuthorizationDto partnerAuthorizationDto) {
        return modelMapper.map(partnerAuthorizationDto, Authorization.class);
    }

}
