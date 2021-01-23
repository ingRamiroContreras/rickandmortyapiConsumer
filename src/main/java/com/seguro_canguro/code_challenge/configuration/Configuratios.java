package com.seguro_canguro.code_challenge.configuration;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.aplication.GetFirstTwoResidentsForPlanet;
import com.seguro_canguro.code_challenge.aplication.ListResidents;
import com.seguro_canguro.code_challenge.infraestructure.PlanetsRickAndMortyApi;
import com.seguro_canguro.code_challenge.infraestructure.db.SimpleCache;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuratios {


    @Bean
    public ListResidents getFirstTwoResidentsForPlanet(){

        return new GetFirstTwoResidentsForPlanet(new PlanetsRickAndMortyApi(new SimpleCache()));

    }
    
}
