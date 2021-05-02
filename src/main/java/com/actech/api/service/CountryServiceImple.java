package com.actech.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actech.api.entity.Country;
import com.actech.api.repository.CountryRepository;

@Service
public class CountryServiceImple implements CountryService{

	@Autowired
	private CountryRepository countryRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Country> findAll(org.springframework.data.domain.Pageable pageable) {
		return countryRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Country> findById(Long id) {	
		return countryRepository.findById(id);
	}

	@Override
	@Transactional
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		countryRepository.deleteById(id);;		
	} 
	
	
	



}
