package com.example.weatherapp.data;

import org.json.JSONObject;

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
        units.json(data.optJSONObject("units"));

        atmosphere=new Atmosphere();
        atmosphere.json(data.optJSONObject("atmosphere"));

        item= new Item();
        item.json(data.optJSONObject("item"));


        astronomy= new Astronomy();
        astronomy.json(data.optJSONObject("astronomy"));


        wind=new Wind();
        wind.json(data.optJSONObject("wind"));


    }
}
