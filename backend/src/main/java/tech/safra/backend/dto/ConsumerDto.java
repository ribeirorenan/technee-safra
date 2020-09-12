package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumerDto {

    private Long id;
    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private String dob;
    private String cpf;
    private String rg;

}
