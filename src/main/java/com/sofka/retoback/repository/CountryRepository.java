package com.sofka.retoback.repository;

import com.sofka.retoback.dto.CountryDTO;
import com.sofka.retoback.models.Country;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Repository
public interface CountryRepository extends ReactiveMongoRepository<Country, String> {
	Optional<CountryDTO> findCountryByCode(String code);
}
