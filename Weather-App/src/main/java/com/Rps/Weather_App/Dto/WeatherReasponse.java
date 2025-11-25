package com.Rps.Weather_App.Dto;

public class WeatherReasponse {
    private  String City;
    private  String Region;
    private String Country;
    private  String Condition;
    private double  Temp ;

    public WeatherReasponse() {
    }

    public WeatherReasponse(String city, String region, String country, String condition, double temp) {
        City = city;
        Region = region;
        Country = country;
        Condition = condition;
        Temp = temp;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public double getTemp() {
        return Temp;
    }

    public void setTemp(double temp) {
        Temp = temp;
    }
}
