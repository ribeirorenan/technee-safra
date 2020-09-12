package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Account;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Default;

import java.util.List;

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

    private List<Account> accounts;

    private List<Authorization> authorizations;

    private List<Default> defaults;
}
