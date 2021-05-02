package com.actech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actech.api.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
