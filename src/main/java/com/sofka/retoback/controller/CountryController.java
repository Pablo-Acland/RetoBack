package com.sofka.retoback.controller;

import com.sofka.retoback.dto.CountryDTO;
import com.sofka.retoback.interfaces.ICountry;
import com.sofka.retoback.models.Country;
import com.sofka.retoback.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
	@Autowired
	private ICountry icountry;
	
	@GetMapping("/api/countries")
	public Flux<CountryDTO> findAllCountries() {
		/*List<CountryDTO> countries = new ArrayList<>();
		icountry.findAllCountry().map(countries::add);*/
		return icountry.findAllCountry();
	}
	
	@GetMapping("/api/country/{code}")
	public ResponseEntity<CountryDTO> findCountryByCode(@PathVariable(name = "code") String code) {
		Optional<CountryDTO> country = icountry.findCountryByCode(code);
		if (country.isPresent()) {
			return ResponseEntity.ok().body(country.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/newCountry")
	public Mono<Country> saveCountry(@Validated @RequestBody Country country) {
		return icountry.save(country);
	}
	
	@PutMapping("api/country/{id}")
	public Mono<Country> updateCountry(@RequestBody CountryDTO newCountry, @PathVariable String id) {
		return icountry.findCountryByCode(id).map(country -> {
			country.setName(newCountry.getName());
			country.setCode(newCountry.getCode());
			return icountry.save(AppUtils.dtoToCountry(country));
		})
		.orElseGet(() -> {
			return icountry.save(AppUtils.dtoToCountry(newCountry));
		});
	}
	
	@DeleteMapping("/api/country/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
		Optional<CountryDTO> country = icountry.findCountryByCode(code);
		if (country.isPresent()) {
			icountry.delete(code);
		} else {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
