package com.sofka.retoback.repository;

import com.sofka.retoback.models.CyclistTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface CyclingTeamRepository extends CrudRepository<CyclistTeam, String> {
	public Mono<CyclistTeam> findCyclingTeamByTeamCode(String teamCode);
}
