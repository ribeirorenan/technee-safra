package tech.safra.backend.dto;

import lombok.Getter;
import lombok.Setter;
import tech.safra.backend.entity.Consumer;
import tech.safra.backend.entity.Partner;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
public class DefaultDto {

    private Long id;

    private Consumer consumer;

    private Partner partner;

    private String due;

    private BigDecimal amount;
}
