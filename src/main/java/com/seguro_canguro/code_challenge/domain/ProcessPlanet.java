package com.seguro_canguro.code_challenge.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessPlanet {

	public static List<Map<String, List<Map<String, String>>>> excecute(List<Planet> planets) {

		planets.stream()
			.map(planet -> Map.of(planet.getName(), planet.getResidents()))
			.forEach(System.out::println);
			//.collect(Collectors.toList());
		return null;
	}

}
