package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.PaymentState;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentBoleto extends Payment {

    private Date dataVencimento;
    private Date dataPagamento;

    public PaymentBoleto() {
    }

    public PaymentBoleto(Integer id, PaymentState state, Pedido order, Date dataVencimento, Date dataPagamento) {
        super(id, state, order);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
