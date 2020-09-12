package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.entity.Partner;

import javax.persistence.ManyToOne;

@Getter
@Setter
public class ConsumerPartnerDto {

    private Long id;

    private Consumer consumer;

    private Partner partner;

}
