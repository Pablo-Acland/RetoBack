package com.sofka.retoback.controller;

import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CyclingTeamController {
	@Autowired
	private CyclingTeamRepository teamRepository;
	
	@GetMapping("/api/teams")
	public List<CyclingTeam> findAllCyclingTeams() {
		List<CyclingTeam> teams = new ArrayList<>();
		teamRepository.findAll().forEach(teams::add);
		return teams;
	}
	
	@PostMapping("/api/newTeam")
	public CyclingTeam saveCyclingTeam(@Validated @RequestBody CyclingTeam newTeam) {
		return teamRepository.save(newTeam);
	}
	
	@GetMapping("/api/team/{team_code}")
	public ResponseEntity<CyclingTeam> findCyclingTeamByCode(@PathVariable(name = "team_code") String teamCode) {
		Optional<CyclingTeam> team = teamRepository.findCyclingTeamByTeamCode(teamCode);
		if (team.isPresent()) return ResponseEntity.ok().body(team.get());
		else return ResponseEntity.notFound().build();
	}
}
