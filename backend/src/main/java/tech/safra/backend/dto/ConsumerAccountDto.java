package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Consumer;

import javax.persistence.ManyToOne;

@Getter
@Setter
public class ConsumerAccountDto {

    private Long id;

    private Consumer consumer;

    private String displayName;
    private String clientId;
    private String secret;

}
