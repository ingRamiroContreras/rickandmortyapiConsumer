package com.seguro_canguro.code_challenge;

import java.util.List;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;

public class FakeExternalApi implements PlanetExternalApi {

    private int numberOfPlanets = 0;
    private int numberOfResidents = 0;
    private boolean onlyTwoResidents = false;

    @Override
    public List<Planet> getPlanets() {

        return onlyTwoResidents ? BuilderPlanet.getTwoResidents(numberOfPlanets)
                : BuilderPlanet.getRandomListOfPlanets(numberOfPlanets, numberOfResidents);
    }

    public FakeExternalApi(int numberOfPlanets, int numberOfResidents, boolean onlyTwoResidents) {
        this.numberOfPlanets = numberOfPlanets;
        this.numberOfResidents = numberOfResidents;
        this.onlyTwoResidents = onlyTwoResidents;
    }

}
