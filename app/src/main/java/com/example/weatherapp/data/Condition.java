package com.example.weatherapp.data;

import org.json.JSONObject;

public class Condition implements JSON {

    private String date;
    private int code;
    private int temperature;
    private String description;




    public int getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void json(JSONObject data) {

        date=data.optString("date");
        code=data.optInt("code");
        temperature=data.optInt("temp");
        description=data.optString("text");

    }
}