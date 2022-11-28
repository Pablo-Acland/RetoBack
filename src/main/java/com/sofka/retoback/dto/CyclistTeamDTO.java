package com.sofka.retoback.dto;


import com.sofka.retoback.models.Country;
import com.sofka.retoback.models.Cyclist;

import java.util.List;

public class CyclistTeamDTO {

    private int id;

    private String name;

    private String teamCode;

    private Country country;

    private List<Cyclist> cyclists;
}
