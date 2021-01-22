package com.seguro_canguro.code_challenge.infraestructure.dto;

import java.util.List;

public class PlanetDto {

    private final String name;
    private final List<String> residentsLinks;

    public PlanetDto(String name, List<String> residentsLinks) {
        this.name = name;
        this.residentsLinks = residentsLinks;
    }

    public String getName() {
        return name;
    }

    public List<String> getResidentsLinks() {
        return residentsLinks;
    }

    @Override
    public String toString() {
        return "PlanetDto [name=" + name + ", residentsLinks=" + residentsLinks + "]";
    }
    
    
}
