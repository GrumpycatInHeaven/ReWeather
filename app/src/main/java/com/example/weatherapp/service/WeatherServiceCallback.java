package com.example.weatherapp.service;

import com.example.weatherapp.data.Channel;

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception e);

}
