package com.nelioalves.cursomc.respositories;

import com.nelioalves.cursomc.domain.Address;
import com.nelioalves.cursomc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
