package com.sofka.retoback.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	private int id;

	private String name;

	private String code;

	private List<CyclistTeam> cyclingTeams;

	private List<Cyclist> cyclists;
}
