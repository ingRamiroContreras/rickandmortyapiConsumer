package com.seguro_canguro.code_challenge.infraestructure.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlanetDto {

    private final String name;
    private final List<String> residentsLinks;

    private PlanetDto(String name, List<String> residentsLinks) {
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

    public static PlanetDto create(String name, List<String> residentsLinks) {
        return new PlanetDto(name, residentsLinks);
    }

    public static List<PlanetDto> mapToPlanetDto(Map<String, Object> map) {

        List<Map<String, Object>> results = (List<Map<String, Object>>) map.get("results");

        List<PlanetDto> listToReturn = results.stream()
                .map(planet -> PlanetDto.create((String) planet.get("name"), (List<String>) planet.get("residents")))
                .collect(Collectors.toList());

        return listToReturn;
    }

}
