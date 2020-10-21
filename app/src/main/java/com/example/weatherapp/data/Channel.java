package com.example.weatherapp.data;

import org.json.JSONObject;

import java.util.Objects;

//JSON Parser for Channel data
public class Channel implements  JSON{
    private Wind wind;
    private Astronomy astronomy;
    private Atmosphere atmosphere;
    private Units units;
    private Item item;

    public Wind getWind() {
        return wind;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void json(JSONObject data) {

        units= new Units();
        units.json(Objects.requireNonNull(data.optJSONObject("units")));

        atmosphere=new Atmosphere();
        atmosphere.json(Objects.requireNonNull(data.optJSONObject("atmosphere")));

        item= new Item();
        item.json(Objects.requireNonNull(data.optJSONObject("item")));


        astronomy= new Astronomy();
        astronomy.json(Objects.requireNonNull(data.optJSONObject("astronomy")));


        wind=new Wind();
        wind.json(Objects.requireNonNull(data.optJSONObject("wind")));


    }
}
