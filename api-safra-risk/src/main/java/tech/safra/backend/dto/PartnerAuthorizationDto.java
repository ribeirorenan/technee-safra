package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.entity.Partner;

@Getter
@Setter
public class PartnerAuthorizationDto {

    private Long id;

    private Consumer consumer;

}
