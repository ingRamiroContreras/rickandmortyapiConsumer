package com.seguro_canguro.code_challenge.domain;

import java.util.List;

final public class Planet {

    private final String name;
    private List<Resident> residents;

    private Planet(String name, List<Resident> residents) {
        this.name = name;
        this.residents = residents;
    }

    public String getName(){
        return this.name;
    }

    public List<Resident> getResidents(){
        return this.residents;
    }


    public static Planet create(String name, List<Resident> residents){
        return new Planet(name, residents);
    }

    @Override
    public String toString() {
        return "Planet [name=" + name + ", residents=" + residents + "]";
    }
    

}
