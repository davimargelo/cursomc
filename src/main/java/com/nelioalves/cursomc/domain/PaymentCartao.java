package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.PaymentState;

import javax.persistence.Entity;

@Entity
public class PaymentCartao extends Payment {

    private Integer parcelas;

    public PaymentCartao() {
    }

    public PaymentCartao(Integer id, PaymentState state, Pedido order, Integer parcelas) {
        super(id, state, order);
        this.parcelas = parcelas;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
