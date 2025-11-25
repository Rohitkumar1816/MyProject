package com.Rps.Weather_App.Dto;

public class DayTemp {
    private String date;
    private Double maxTem;
    private Double avgTem;
    private Double minTem;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(Double maxTem) {
        this.maxTem = maxTem;
    }

    public Double getAvgTem() {
        return avgTem;
    }

    public void setAvgTem(Double avgTem) {
        this.avgTem = avgTem;
    }

    public Double getMinTem() {
        return minTem;
    }

    public void setMinTem(Double minTem) {
        this.minTem = minTem;
    }
}