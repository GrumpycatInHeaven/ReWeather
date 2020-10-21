package com.example.weatherapp.data;

import org.json.JSONObject;

import java.util.Objects;

//JSON Parser for Item data
public class Item implements JSON {

    public Condition getCondition() {
        return condition;
    }


    private Condition condition;
    @Override
    public void json(JSONObject data) {
        condition = new Condition();
        condition.json(Objects.requireNonNull(data.optJSONObject("condition")));


    }
}