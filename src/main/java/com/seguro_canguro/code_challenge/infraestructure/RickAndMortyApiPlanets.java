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

public class RickAndMortyApiPlanets implements PlanetExternalApi {

    private String URL = "https://rickandmortyapi.com/api/location?type=planet";
    private CachingMethod cachingMethod;

    public RickAndMortyApiPlanets(CachingMethod cachingMethod) {

        this.cachingMethod = cachingMethod;
    }

    @Override
    public List<Planet> getPlanets() {

        long initTime = System.currentTimeMillis();

        String responseApi = Request.sendRequest(URL);
        Map<String, Object> convertResponse = Request.mapperJsonResultToListMap(responseApi);
        List<PlanetDto> planetDtoList = PlanetDto.mapToPlanetDto(convertResponse);
        List<Planet> listToReturn = processPlanetDtoList(planetDtoList);

        System.out.println(" ----------------->  tiempo que se demoro en milisegundos: "
                + (System.currentTimeMillis() - initTime));
        return listToReturn;

    }

    private List<Planet> processPlanetDtoList(List<PlanetDto> planetDtolist) {

        return planetDtolist.stream().map(getResidentsData()).peek(System.out::println).collect(Collectors.toList());

    }

    private Function<PlanetDto, Planet> getResidentsData() {
        return planetDto -> {

            List<Resident> residentList = planetDto.getResidentsLinks().stream().limit(2).map(SendRequestResident())
                    .map(responseResidents -> Request.mapperJsonResultToListMap(responseResidents))
                    .map(hasMapResident -> Resident.mapToResident(hasMapResident)).collect(Collectors.toList());

            return Planet.create(planetDto.getName(), residentList);
        };
    }

    private Function<? super String, ? extends String> SendRequestResident() {
        return link -> {

            String linksinDbMemory = cachingMethod.get(link);
            if (linksinDbMemory != null) return linksinDbMemory;
            
            String response = Request.sendRequest(link);
            cachingMethod.add(link, response);
            return response;

        };
    }

}
