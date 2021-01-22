package com.seguro_canguro.code_challenge.infraestructure;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;
import com.seguro_canguro.code_challenge.domain.Resident;
import com.seguro_canguro.code_challenge.infraestructure.dto.PlanetDto;


public class RickAndMortyApiPlanets implements PlanetExternalApi {

    private String URL = "https://rickandmortyapi.com/api/location?type=planet";


    public RickAndMortyApiPlanets() {
    }

    @Override
    public List<Planet> getPlanets() {

        long initTime = System.currentTimeMillis();

        String responseApi = Request.sendRequest(URL);
        Map<String, Object> convertResponse = Request.mapperJsonResultToListMap(responseApi);
        List<PlanetDto> planetDtoList = PlanetDto.mapToPlanetDto(convertResponse);
        List<Planet> listToReturn = processPlanetDtoList(planetDtoList);

        System.out.println(" ----------------->  tiempo que se demoro en milisegundos: "  + (System.currentTimeMillis() - initTime));
        return listToReturn;

    }

    private List<Planet> processPlanetDtoList(List<PlanetDto> planetDtolist){

        return planetDtolist.stream()
                .map(getResidentsData())
                .peek(System.out::println)
                .collect(Collectors.toList());

        
    }

    private Function<PlanetDto,Planet> getResidentsData() {
        return planetDto -> {

            List<Resident> residentList = planetDto.getResidentsLinks().stream()
            .map(link -> Request.sendRequest(link))
            .map( responseResidents -> Request.mapperJsonResultToListMap(responseResidents))
            .map( hasMapResident -> mapToResident(hasMapResident))
            .collect(Collectors.toList());
            
            return Planet.create(planetDto.getName(), residentList);
        };
    }

    private Resident mapToResident(Map<String, Object> hasMapResident) {

        String nameResident = (String) hasMapResident.get("name");
        String statusResident = (String) hasMapResident.get("status");
        String genderResident = (String) hasMapResident.get("gender");
        List<String> episodes = (List<String>) hasMapResident.get("episode");

        return Resident.create(nameResident, statusResident, genderResident, episodes.size());
    }

    
}
