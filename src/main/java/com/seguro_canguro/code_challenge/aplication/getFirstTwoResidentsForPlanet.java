package com.seguro_canguro.code_challenge.aplication;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;
import com.seguro_canguro.code_challenge.domain.ProcessPlanet;

public class getFirstTwoResidentsForPlanet implements ListResidents {

    private PlanetExternalApi planetExternalApi;

    public getFirstTwoResidentsForPlanet(PlanetExternalApi planetExternalApi) {
        this.planetExternalApi = planetExternalApi;
    }

    @Override
    public List<Map<String,List<Map<String,String>>>> handle() {
        List<Planet> planets = planetExternalApi.getPlanets();

        List<Map<String,List<Map<String,String>>>> processPlanets = ProcessPlanet.excecute(planets);

        return processPlanets;
    }

}
