package com.company;

public class WeatherData {
    private String city;
    private double averageTemp;
    private double averageHumidity;

    public WeatherData(String c, double t, double h) {
        city = c;
        averageTemp = t;
        averageHumidity = h;
    }

    public String getCity() {
        return city;
    }
    public double getAverageTemp() {
        return averageTemp;
    }
    public double getAverageHumidity() {
        return averageHumidity;
    }


}
