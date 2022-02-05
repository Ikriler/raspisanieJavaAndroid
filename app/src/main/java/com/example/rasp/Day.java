package com.example.rasp;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Day {

    private String title_day;
    private List<Para> paras;

    public Day(String title_day, List<Para> paras){
        this.title_day = title_day;
        this.paras = paras;
    }

    public String getTitle_day(){
        return this.title_day;
    }

    public List<Para> getParas(){
        return this.paras;
    }

    public void setTitle_day(String title_day){
        this.title_day = title_day;
    }

    public void setParas(List<Para> paras){
        this.paras = paras;
    }
}
