package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.PartnerDto;
import tech.safra.backend.entity.Partner;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.PartnerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PartnerService partnerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PartnerDto create(@RequestBody PartnerDto partnerDto) {
        Partner partner  = convertToEntity(partnerDto);
        return convertToDto(partnerService.create(partner));
    }

    @GetMapping
    @ResponseBody
    public List<PartnerDto> getPartners() {
        List<Partner> partners = partnerService.getAll();
        return partners.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PartnerDto getPartner(@PathVariable("id") Long id) {
        return convertToDto(partnerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePartner(@PathVariable("id") Long id) {
        try {
            partnerService.deleteById(id);
            return HttpStatus.OK;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Partner not found", null);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PartnerDto updatePartner(@PathVariable("id") Long id, @RequestBody PartnerDto partnerDto) {
        Partner updatePartner = partnerService.updatePartner(id, convertToEntity(partnerDto));
        return convertToDto(updatePartner);
    }


    private PartnerDto convertToDto(Partner partner) {
        return  modelMapper.map(partner, PartnerDto.class);
    }

    private Partner convertToEntity(PartnerDto partnerDto) {
        return modelMapper.map(partnerDto, Partner.class);
    }

}
