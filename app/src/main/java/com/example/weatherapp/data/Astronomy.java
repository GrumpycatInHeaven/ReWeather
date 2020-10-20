package com.example.weatherapp.data;

import org.json.JSONObject;

public class Astronomy implements JSON {


    private String sunrise;
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    @Override
    public void json(JSONObject data) {
        sunrise=data.optString("sunrise");
        sunset=data.optString("sunset");

    }
}
