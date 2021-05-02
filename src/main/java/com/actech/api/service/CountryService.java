package com.actech.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.actech.api.entity.Country; 

		public interface CountryService {
			
			public Iterable<Country> findAll();
			
			public Page<Country> findAll( Pageable pageable );
			
			public Optional<Country> findById(Long id);
			
			public Country save (Country country);	
			
			public void deleteById(Long id);
		
		}
