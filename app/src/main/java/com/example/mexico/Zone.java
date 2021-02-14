package com.example.mexico;

public class Zone {

    private String name;
    private int imageResourceId;

    public Zone() {
    }

    public Zone(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public static final Zone[] zones = {
            new Zone("Teotihuacan", R.drawable.rec_teotihuacan),
            new Zone("Cholula", R.drawable.rec_cholula),
            new Zone("Monte Alban", R.drawable.rec_monte_alban),
            new Zone("Mitla", R.drawable.rec_mitla),
            new Zone("Palenque", R.drawable.rec_palenque),
            new Zone("Uxmal", R.drawable.rec_uxmal),
            new Zone("Chichen-Itza", R.drawable.rec_chichen_itza),
            new Zone("Tulum", R.drawable.rec_tulum)

    };

}
