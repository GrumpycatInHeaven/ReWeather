package com.example.weatherapp.data;

import org.json.JSONObject;

public class Wind implements JSON {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    @Override
    public void json(JSONObject data) {
        speed=data.optInt("speed");
    }
}
