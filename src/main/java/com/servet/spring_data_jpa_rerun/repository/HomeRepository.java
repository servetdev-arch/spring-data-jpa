package com.servet.spring_data_jpa_rerun.repository;

import com.servet.spring_data_jpa_rerun.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home,Long> {
}
