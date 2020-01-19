package com.nelioalves.cursomc.respositories;

import com.nelioalves.cursomc.domain.Payment;
import com.nelioalves.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
