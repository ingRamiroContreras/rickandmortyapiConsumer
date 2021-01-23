package com.seguro_canguro.code_challenge.aplication;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;
import com.seguro_canguro.code_challenge.domain.ProcessPlanet;
import com.seguro_canguro.code_challenge.domain.Resident;

public class GetFirstTwoResidentsForPlanet implements ListResidents {

    private PlanetExternalApi planetExternalApi;

    public GetFirstTwoResidentsForPlanet(PlanetExternalApi planetExternalApi) {
        this.planetExternalApi = planetExternalApi;
    }

    @Override
    public List<Map<String, List<Resident>>> handle() {

        List<Planet> planets = planetExternalApi.getPlanets();
        List<Map<String,List<Resident>>> processPlanets = ProcessPlanet.excecute(planets);

        return processPlanets;
    }

}
