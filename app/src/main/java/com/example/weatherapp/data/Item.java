package com.example.weatherapp.data;

import org.json.JSONObject;
public class Item implements JSON {

    public Condition getCondition() {
        return condition;
    }


    private Condition condition;
    @Override
    public void json(JSONObject data) {
        condition = new Condition();
        condition.json(data.optJSONObject("condition"));


    }
}