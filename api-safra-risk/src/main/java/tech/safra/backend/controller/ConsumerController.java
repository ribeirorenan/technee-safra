package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.ConsumerDto;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.ConsumerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consumer")
@CrossOrigin
public class ConsumerController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ConsumerDto create(@RequestBody ConsumerDto consumerDto) {
        Consumer consumer  = convertToEntity(consumerDto);
        return convertToDto(consumerService.create(consumer));
    }

    @GetMapping
    @ResponseBody
    public List<ConsumerDto> getConsumers() {
        List<Consumer> consumers = consumerService.getAll();
        return consumers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConsumerDto getConsumer(@PathVariable("id") Long id) {
        return convertToDto(consumerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteConsumer(@PathVariable("id") Long id) {
        try {
            consumerService.deleteById(id);
            return HttpStatus.OK; 
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Consumer not found", null);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsumerDto updateConsumer(@PathVariable("id") Long id, @RequestBody ConsumerDto consumerDto) {
        Consumer updateConsumer = consumerService.updateConsumer(id, convertToEntity(consumerDto));
        return convertToDto(updateConsumer);
    }


    private ConsumerDto convertToDto(Consumer consumer) {
        return  modelMapper.map(consumer, ConsumerDto.class);
    }

    private Consumer convertToEntity(ConsumerDto consumerDto) {
        return modelMapper.map(consumerDto, Consumer.class);
    }
    
}
