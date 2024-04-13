package com.example.demo.enums;



public enum BlrCities {

    MINSK("Minsk,BLR"),
    BREST("Brest,BLR"),
    GOMEL("Gomel,BLR"),
    MOGILEV("Mogilev,BLR"),
    VITEBSK("Vitebsk,BLR"),
    GRODNO("Grodno,BLR");
    private final String city;

    BlrCities(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }


}
