package com.seguro_canguro.code_challenge.aplication;

import java.util.List;
import java.util.Map;

import com.seguro_canguro.code_challenge.domain.Resident;

public interface ListResidents {

    public List<Map<String, List<Resident>>> handle();

}
