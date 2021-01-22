package com.seguro_canguro.code_challenge.domain;

public class Resident {

    private String name;
    private String status;
    private String gender;
    private Integer episodesCount;

    private Resident(String name, String status, String gender, Integer episodesCount) {
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.episodesCount = episodesCount;
    }

    public static Resident create(String name, String status, String gender, Integer episodesCount) {
        return new Resident(name, status, gender, episodesCount);
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getGender() {
        return gender;
    }

    public Integer getEpisodesCount() {
        return episodesCount;
    }

    // se puedes retornar todos los tributos en un hashMap y setearlos de una vez en el response en ves de los geters

}
