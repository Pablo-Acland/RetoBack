package com.sofka.retoback.services;

import com.sofka.retoback.dto.CountryDTO;
import com.sofka.retoback.interfaces.ICountry;
import com.sofka.retoback.models.Country;
import com.sofka.retoback.repository.CountryRepository;
import com.sofka.retoback.utils.AppUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryService implements ICountry {

    @Autowired
    private CountryRepository repository;

    @Override
    public Flux<CountryDTO> findAllCountry() {
        return AppUtils.countryListToDto(repository.findAll());
    }

    @Override
    public Mono<Country> save(Country country) {
        return repository.save(country);
    }

    @Override
    public void delete(String id) {
        //plantear posible no existencia
        repository.deleteById(id);

    }
    public Optional<CountryDTO> findCountryByCode(String code){
        return repository.findCountryByCode(code);
    }

}
