package com.Rps.Weather_App.Dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({ "weatherReasponse", "days" })

public  class WeatherForecast {
    private WeatherReasponse weatherReasponse;
    private List<DayTemp> days;

    public WeatherReasponse getWeatherReasponse() {
        return weatherReasponse;
    }

    public void setWeatherReasponse(WeatherReasponse weatherReasponse) {
        this.weatherReasponse = weatherReasponse;
    }

    public List<DayTemp> getDays() {
        return days;
    }

    public void setDays(List<DayTemp> days) {
        this.days = days;
    }
}