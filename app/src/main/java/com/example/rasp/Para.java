package com.example.rasp;

import java.util.List;

public class Para {

    public String para_number;

    public List<Predmet> predmets;

    public Para(String para_number, List<Predmet> predmets){
        this.para_number = para_number;
        this.predmets = predmets;
    }

    public String getParaNumber() {
        return this.para_number;
    }

    public List<Predmet> getPredmets(){
        return this.predmets;
    }

    public void setParaNumber(String para_number) {
        this.para_number = para_number;
    }

    public void setPredmets(List<Predmet> predmets) {
        this.predmets = predmets;
    }
}
