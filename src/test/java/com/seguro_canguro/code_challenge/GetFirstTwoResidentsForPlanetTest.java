package com.seguro_canguro.code_challenge;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.aplication.GetFirstTwoResidentsForPlanet;
import com.seguro_canguro.code_challenge.domain.PlanetExternalApi;
import com.seguro_canguro.code_challenge.domain.Resident;

import org.junit.jupiter.api.Test;

public class GetFirstTwoResidentsForPlanetTest {


    @Test
    public void get_residents_for_planet(){
        
        PlanetExternalApi fakeApi = new FakeExternalApi(5, 3, false);
        GetFirstTwoResidentsForPlanet aplication = new GetFirstTwoResidentsForPlanet(fakeApi);

        List<Map<String, List<Resident>>> list = aplication.handle();

        assertTrue("List of Planets is not empty", !list.isEmpty());
    }

    @Test
    public void get_first_two_residents_for_planet(){
        
        PlanetExternalApi fakeApi = new FakeExternalApi(5, 5, true);
        GetFirstTwoResidentsForPlanet aplication = new GetFirstTwoResidentsForPlanet(fakeApi);

        List<Map<String, List<Resident>>> list = aplication.handle();

        Integer maxResidentsOfPlanets = list.stream()
            .map( planet -> {
                return planet.values().stream().findFirst().get().size();
            })
            .peek(System.out::println)
            .reduce(0, (acum, val) -> {
            if (val >= acum) {
                return val;
            }
            return acum;
        });

        assertTrue("List of Planets is not empty", maxResidentsOfPlanets <= 2 );
    }
    
}
