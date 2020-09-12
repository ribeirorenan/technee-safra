package tech.safra.backend.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "consumer_partners")
public class ConsumerPartner {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Consumer consumer;

    @ManyToOne
    private Partner partner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
