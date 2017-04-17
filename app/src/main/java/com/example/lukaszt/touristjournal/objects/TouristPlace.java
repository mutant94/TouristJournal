package com.example.lukaszt.touristjournal.objects;

/**
 * Created by lukaszt on 06.04.2017.
 */

public enum TouristPlace {
    PalacBranicki();
    public int nameId;
    public int shortDescriptionId;
    public int longDescriptionId;
    public int imageResource;
    public TouristCity city;
    private TouristPlace(){

    }


}
