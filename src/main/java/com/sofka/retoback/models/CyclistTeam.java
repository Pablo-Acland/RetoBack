package com.sofka.retoback.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "team")
public class CyclistTeam {

	@Id
	private int id;

	private String name;

	private String teamCode;

	private Country country;

	private List<Cyclist> cyclists;
}
