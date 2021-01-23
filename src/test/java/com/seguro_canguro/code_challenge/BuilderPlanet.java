package com.seguro_canguro.code_challenge;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.javafaker.Faker;
import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.Resident;

public class BuilderPlanet {

	public static List<Planet> getRandomListOfPlanets(int numberOfPlanets, int numberOfResidents) {
		return Stream.iterate(0, i -> i + 1)
			  .limit(numberOfPlanets)
			  .map( e -> createListOfResidents(numberOfResidents))
			  .map( e -> createPlanet(e))
			  .collect(Collectors.toList());
		
	}

	
	private static  List<Resident> createListOfResidents(int numberOfResidents) {
		return Stream.iterate(0, i -> i + 1)
			  .limit(numberOfResidents)
			  .map( e -> createResident())
			  .collect(Collectors.toList());
	}

	private static Resident createResident() {
		Faker usFaker = new Faker(new Locale("en-US"));
	    Random rand = new Random();
		return Resident.create(usFaker.book().title(), usFaker.book().author(), usFaker.book().genre() , rand.nextInt(10));
	}

	private static Planet createPlanet(List<Resident> resisents) {
		Faker usFaker = new Faker(new Locale("en-US"));
		return Planet.create(usFaker.beer().name(), resisents);
	}

	public static List<Planet> getTwoResidents(int numberOfPlanets) {
		return Stream.iterate(0, i -> i + 1)
			  .limit(numberOfPlanets)
			  .map( e -> createListOfResidents(2))
			  .map( e -> createPlanet(e))
			  .collect(Collectors.toList());
		
	}
	

}
