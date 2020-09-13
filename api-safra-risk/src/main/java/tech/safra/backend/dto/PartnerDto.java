package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Authorization;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.entity.Partner;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PartnerDto {

    private Long id;

    private String name;

    private String url;

    private List<PartnerAuthorizationDto> authorizations;
}
