package com.nelioalves.cursomc.respositories;

import com.nelioalves.cursomc.domain.Address;
import com.nelioalves.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
