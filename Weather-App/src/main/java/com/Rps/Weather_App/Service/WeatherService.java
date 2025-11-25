package com.Rps.Weather_App.Service;

import com.Rps.Weather_App.Dto.*;
//import com.Rps.Weather_App.Dto.ForeCast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
      @Value("${weather.api.key}")
    private  String apikey;
   @Value("${weather.api.url}")
   private  String apiurl;
      @Value("${weather.forecast.url}")
      private  String apiurlForecast;
      private RestTemplate template=new RestTemplate();
      public String Test(){
        return "Good";
    }

    public WeatherReasponse Getdata(String city){
       String url= apiurl+"?key="+apikey+"&q="+city;
       Root  response= template.getForObject(url, Root.class);
       WeatherReasponse weatherReasponse=new WeatherReasponse();
       weatherReasponse.setCity(response.location.name);
       weatherReasponse.setRegion(response.location.region);
       weatherReasponse.setCountry(response.location.country);
       String condition= response.getCurrent().getCondition().getText();
       weatherReasponse.setCondition(condition);
       weatherReasponse.setTemp(response.getCurrent().temp_c);

       return weatherReasponse;
    }
    public WeatherForecast weatherForecast(String city, int Days){
        WeatherReasponse weatherReasponse= Getdata(city);
        WeatherForecast response= new WeatherForecast();
        response.setWeatherReasponse(weatherReasponse);

        List<DayTemp>dayTemps =new ArrayList<>();
        String url=apiurlForecast+"?key="+apikey+"&q="+city+"&days="+Days;
        Root apireponse=template.getForObject(url, Root.class);
        Forecast forecast =apireponse.getForecast();

        ArrayList<Forecastday>forecastdays= forecast.getForecastday();

        for (Forecastday rs: forecastdays){
            DayTemp d=new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTem(rs.getDay().mintemp_c);
            d.setAvgTem(rs.getDay().avgtemp_c);
            d.setMaxTem(rs.getDay().maxtemp_c);
            dayTemps.add(d);
        }
        response.setDays(dayTemps);
        return response;

    }
}
