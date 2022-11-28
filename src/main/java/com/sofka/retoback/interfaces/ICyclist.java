package com.sofka.retoback.interfaces;

import com.sofka.retoback.models.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICyclist {
    Flux<Cyclist> findAllCyclists();
    Mono<Cyclist> save(Cyclist cyclist);

}
