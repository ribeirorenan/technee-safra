package tech.safra.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.safra.backend.dto.UserDto;
import tech.safra.backend.entity.User;
import tech.safra.backend.exception.NotFoundException;
import tech.safra.backend.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto create(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(userService.create(user));
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> getUsers() {
        List<User> users = userService.getAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return convertToDto(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
            return HttpStatus.OK; 
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("User not found", null);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        User updateUser = userService.updateUser(id, convertToEntity(userDto));
        return convertToDto(updateUser);
    }


    private UserDto convertToDto(User user) {
        return  modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
    
}
