package com.example.weatherapp.data;

import org.json.JSONObject;

public class Atmosphere implements JSON {
    private String humidity;
    private String pressure;


    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    @Override
    public void json(JSONObject data) {

        humidity = data.optString("humidity");
        pressure = data.optString("pressure");
    }
}