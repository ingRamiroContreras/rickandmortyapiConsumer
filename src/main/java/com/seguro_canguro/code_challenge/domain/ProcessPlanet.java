package com.seguro_canguro.code_challenge.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessPlanet {


	public static List<Map<String, List<Resident>>> excecute(List<Planet> planets) {

		return planets.stream()
			.map(planet -> Map.of(planet.getName(), planet.getResidents()))
			.collect(Collectors.toList());
		
	}

}
