package com.seguro_canguro.code_challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.seguro_canguro.code_challenge.domain.Planet;
import com.seguro_canguro.code_challenge.infraestructure.RickAndMortyApiPlanets;

import org.junit.jupiter.api.Test;

public class RickAndMortyApiPlanetsTest {



    @Test
    public void sendRequest(){

        RickAndMortyApiPlanets rickAndMortyApiPlanets = new RickAndMortyApiPlanets();
        List<Planet> planets = rickAndMortyApiPlanets.getPlanets();

        assertTrue(Boolean.TRUE);
    }
    
}
