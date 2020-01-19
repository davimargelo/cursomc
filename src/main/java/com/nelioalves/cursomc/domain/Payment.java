package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.PaymentState;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {

    @Id
    private Integer id;
    private Integer state;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Pedido order;

    public Payment() {
    }

    public Payment(Integer id, PaymentState state, Pedido order) {
        this.id = id;
        this.state = state.getCod();
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentState getState() {
        return PaymentState.toEnum(state);
    }

    public void setState(PaymentState state) {
        this.state = state.getCod();
    }

    public Pedido getOrder() {
        return order;
    }

    public void setOrder(Pedido order) {
        this.order = order;
    }
}
