package com.seguro_canguro.code_challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.domain.ProcessPlanet;
import com.seguro_canguro.code_challenge.domain.Resident;

import org.junit.jupiter.api.Test;

public class ProcessPlanetTest {


    @Test
    public void procces_normal_list_planets(){

        List<Map<String, List<Resident>>> response = ProcessPlanet.excecute(BuilderPlanet.getNormalListOfPlanets());

        assertTrue(Boolean.TRUE);
    }
    
}
