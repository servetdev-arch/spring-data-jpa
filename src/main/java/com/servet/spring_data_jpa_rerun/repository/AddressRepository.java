package com.servet.spring_data_jpa_rerun.repository;

import com.servet.spring_data_jpa_rerun.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
