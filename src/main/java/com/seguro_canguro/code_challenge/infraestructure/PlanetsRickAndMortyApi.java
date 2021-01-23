package com.seguro_canguro.code_challenge.infraestructure;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.seguro_canguro.code_challenge.domain.CachingMethod;
import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;
import com.seguro_canguro.code_challenge.domain.Resident;
import com.seguro_canguro.code_challenge.infraestructure.dto.PlanetDto;

public class PlanetsRickAndMortyApi implements PlanetExternalApi {

    private String URL = "https://rickandmortyapi.com/api/location?type=planet";
    private CachingMethod cachingMethod;

    public PlanetsRickAndMortyApi(CachingMethod cachingMethod) {

        this.cachingMethod = cachingMethod;
    }

    @Override
    public List<Planet> getPlanets() {

        long initTime = System.currentTimeMillis();

        String responseApi = HttpRequest.send(URL);
        Map<String, Object> convertResponse = HttpRequest.mapperJsonResultToListMap(responseApi);
        List<PlanetDto> planetDtoList = PlanetDto.mapToPlanetDto(convertResponse);
        List<Planet> listToReturn = processPlanetDtoList(planetDtoList);

        System.out.println("Tinme : " + (System.currentTimeMillis() - initTime));
        return listToReturn;

    }

    private List<Planet> processPlanetDtoList(List<PlanetDto> planetDtolist) {

        return planetDtolist.stream()
            .map(getResidentsData())
            .collect(Collectors.toList());

    }

    private Function<PlanetDto, Planet> getResidentsData() {
        return planetDto -> {

            List<Resident> residentList = planetDto.getResidentsLinks().stream()
                    .limit(2)
                    .map(link -> sendRequestResident(link))
                    .map(responseResidents -> HttpRequest.mapperJsonResultToListMap(responseResidents))
                    .map(hasMapResident -> Resident.mapToResident(hasMapResident))
                    .collect(Collectors.toList());

            return Planet.create(planetDto.getName(), residentList);
        };
    }

    private String sendRequestResident(String link) {
        
        String linksinDbMemory = cachingMethod.get(link);
        
        if (linksinDbMemory != null) 
            return linksinDbMemory;
        
        String response = HttpRequest.send(link);
        cachingMethod.add(link, response);
        return response;
    }

}
