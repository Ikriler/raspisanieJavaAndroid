package com.example.rasp;

public class Predmet {
    private String name_predmet;
    private String name_prepod;

    public Predmet(String name_predmet, String name_prepod) {
        this.name_predmet = name_predmet;
        this.name_prepod = name_prepod;
    }

    public String getNamePredmet() {
        return this.name_predmet;
    }

    public String getNamePrepod() {
        return this.name_prepod;
    }

    public void setNamePredmet(String name_predmet) {
        this.name_predmet = name_predmet;
    }

    public void setNamePrepod(String name_prepod) {
        this.name_prepod = name_prepod;
    }
}
