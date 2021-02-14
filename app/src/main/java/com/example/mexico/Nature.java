package com.example.mexico;

public class Nature {

    private String name;
    private int imageResourceId;

    public Nature() {
    }

    public Nature(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public static final Nature[] natures = {
            new Nature("Sumidero", R.drawable.rec_sumidero),
            new Nature("Celestun", R.drawable.rec_celestun),
            new Nature("Agua Azul", R.drawable.rec_agua_azul),
            new Nature("Misol-Ha", R.drawable.rec_misol_ha),
            new Nature("Santa Maria de El Tule", R.drawable.rec_tule),
            new Nature("Cacahuamilpa", R.drawable.rec_cacahuamilpa),
            new Nature("Eiypantla", R.drawable.rec_eiypantla),
            new Nature("Hierve el Agua", R.drawable.rec_hierve_el_agua)
    };

}
