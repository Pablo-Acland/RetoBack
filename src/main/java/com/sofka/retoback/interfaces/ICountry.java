package com.sofka.retoback.interfaces;

import com.sofka.retoback.dto.CountryDTO;
import com.sofka.retoback.models.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface ICountry {
    Flux<CountryDTO> findAllCountry();
    Mono<Country> save(Country country);
    void delete(String id);
    Optional<CountryDTO> findCountryByCode(String code);

}
