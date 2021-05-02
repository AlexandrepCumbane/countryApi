package com.actech.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actech.api.entity.Country;
import com.actech.api.service.CountryService;

@RestController
@RequestMapping("/api/country2b")
public class CountryController {
	
		@Autowired
		private CountryService countryService;
		
		//create a new country
		@PostMapping
		public ResponseEntity<?> create ( @RequestBody Country  country){
			return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
		}
		
		@GetMapping("/country")
		public  ResponseEntity<?> list(){		
			 return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
		}
		
		// Get an Country
		@GetMapping("/{id}")
		public ResponseEntity<?> read (@PathVariable(value="id") Long id){
			Optional<Country> oCountry = countryService.findById(id);
			
			if(!oCountry.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oCountry);
		}
		
		// Update an Country
		@PutMapping("/{id}")
		public ResponseEntity<?> update(@RequestBody Country countryDetails, @PathVariable (value= "id") Long countryid ){

			Optional<Country> country = countryService.findById(countryid);
			
			if(!country.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			country.get().setArea(countryDetails.getName());
			country.get().setCapital(countryDetails.getCapital());
			country.get().setName(countryDetails.getName());
			country.get().setRegion(countryDetails.getRegion());
			country.get().setSubRegion(countryDetails.getSubRegion());
			
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country.get()));
		}
		
		
		//delete an country
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable(value = "id") Long id){
			
			if(countryService.findById(id).isPresent()) {
				
			return ResponseEntity.notFound().build();
			
			}
			
			countryService.deleteById(id);
			return ResponseEntity.ok().build();
			
			
		}
		
//		Read all countrys
		
		@GetMapping
		public List<Country> readAll (){
		
			List<Country> country = StreamSupport
					.stream(countryService.findAll()
					.spliterator(), false)
					.collect(Collectors.toList());
			
			return country;
		}
		
}
