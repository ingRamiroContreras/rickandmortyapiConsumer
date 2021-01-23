package com.seguro_canguro.code_challenge.accept;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.infraestructure.PlanetsRickAndMortyApi;
import com.seguro_canguro.code_challenge.infraestructure.db.SimpleCache;

import org.junit.jupiter.api.Test;

public class RickAndMortyApiPlanetsTest {



    @Test
    public void sendRequest(){

        PlanetsRickAndMortyApi rickAndMortyApiPlanets = new PlanetsRickAndMortyApi(new SimpleCache());
        List<Planet> planets = rickAndMortyApiPlanets.getPlanets();

        assertTrue(!planets.isEmpty());
    }
    
}
