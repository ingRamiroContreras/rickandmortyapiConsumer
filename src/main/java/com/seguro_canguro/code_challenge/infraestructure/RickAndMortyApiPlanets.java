package com.seguro_canguro.code_challenge.infraestructure;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;

public class RickAndMortyApiPlanets implements PlanetExternalApi {

    final String URL = "https://rickandmortyapi.com/api/location?type=planet";
    private Request request;

    public RickAndMortyApiPlanets(Request request) {
        this.request = request;
    }
    

    @Override
    public List<Planet> getPlanets() {

        String responseApi = request.sendRequest();
        Map<String, Object> comvertResponse = request.mapperJsonResultToListMap(responseApi);
        
        
    }



   
    
}
