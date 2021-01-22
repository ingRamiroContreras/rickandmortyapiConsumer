package com.seguro_canguro.code_challenge.controller;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.aplication.ListResidents;
import com.seguro_canguro.code_challenge.domain.Resident;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getPlanetsController {

    ListResidents  service;

	public getPlanetsController(ListResidents service) {
		this.service = service;
	}

    


    @GetMapping("api/planets")
    public List<Map<String, List<Resident>>> get(){

       return service.handle();

    }
    
}
