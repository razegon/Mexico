package com.example.mexico;

public class City {

    private String name;
    private int imageResourceId;

    public City(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public static final City[] cities = {
            new City("CDMX", R.drawable.rec_cdmx),
            new City("Taxco", R.drawable.rec_taxco),
            new City("Acapulco", R.drawable.rec_acapulco),
            new City("Puebla", R.drawable.rec_puebla),
            new City("Oaxaca", R.drawable.rec_oaxaca),
            new City("San Cristobal", R.drawable.rec_san_cristobal),
            new City("Campeche", R.drawable.rec_campeche),
            new City("Merida", R.drawable.rec_merida),
            new City("Queretaro", R.drawable.rec_queretaro),
            new City("Cancun", R.drawable.rec_cancun)
    };

}
