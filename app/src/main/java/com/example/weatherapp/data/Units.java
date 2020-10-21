package com.example.weatherapp.data;

import org.json.JSONObject;

//JSON Parser for Units data
public class Units implements JSON {
    private  String date;
    private String speed;
    private String temperature;



    public String getDate() {
        return date;
    }

    public String getSpeed() {
        return speed;
    }


    public String getTemperature() {
        return temperature;
    }


    @Override
    public void json(JSONObject data) {
        temperature= data.optString("temperature");
        speed=data.optString("speed");
        date=data.optString("date");

    }

}
