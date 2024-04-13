package com.example.demo.service.weather;

import com.example.demo.dto.CityWeatherDTO;
import com.example.demo.enums.BlrCities;

import com.example.demo.repository.WeatherRepository;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


import java.util.List;


//@Service
public class WeatherServiceImpl implements WeatherService{
//    @Autowired
//    private JavaMailSender mailSender;
//
//    private final WeatherRepository weatherRepository;
//
//    public WeatherServiceImpl(WeatherRepository weatherRepository) {
//        this.weatherRepository = weatherRepository;
//
//    }
//
//    @Override
//    public List<CityWeatherDTO> getCitiesWeather() {
//
////        return weatherRepository.findAll();
//        return null;
//    }
//
//    @Override
//    public void addCity() {
//
//    }
//    @Scheduled(cron = "@daily")
//    public void sendNewMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("azaraergp1@gmail.com");
//        message.setSubject("Weather today");
//
//
//        BlrCities city = BlrCities.valueOf("Minsk,BLR");
//        CityWeather cityWeather = weatherRepository.findByCityName(city.getCity());
//        message.setText("Max temp  = " + cityWeather.getMaxTemp().toString() + "\n" +
//                "Min temp  = " + cityWeather.getMinTemp().toString());
//        mailSender.send(message);
//    }
//
//    @Override
//    @Scheduled(cron = "@daily")
//    public void updateCity() {
//        for(BlrCities city : BlrCities.values()){
//            try {
////                weatherRepository.save(mapEntityToDto(timelineRequestHttpClient(city.getCity())));
//                System.out.println("База данных обновтлась");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private CityWeather timelineRequestHttpClient(String cityName) throws Exception {
//        CityWeather cityWeather;
//        //set up the end point
//        String apiEndPoint="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
//        String location=cityName;
//        String startDate=null;
//        String endDate=null;
//        String unitGroup="metric";
//        String apiKey="95ZZVVKNGUTS49FG6DE5Y3BX4";
//        StringBuilder requestBuilder=new StringBuilder(apiEndPoint);
//        requestBuilder.append(URLEncoder.encode(location, StandardCharsets.UTF_8.toString()));
//        if (startDate!=null && !startDate.isEmpty()) {
//            requestBuilder.append("/").append(startDate);
//            if (endDate!=null && !endDate.isEmpty()) {
//                requestBuilder.append("/").append(endDate);
//            }
//        }
//        URIBuilder builder = new URIBuilder(requestBuilder.toString());
//        builder.setParameter("unitGroup", unitGroup)
//                .setParameter("key", apiKey);
//        HttpGet get = new HttpGet(builder.build());
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpResponse response = httpclient.execute(get);
//        String rawResult=null;
//        try {
//            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
//                System.out.printf("Bad response status code:%d%n", response.getStatusLine().getStatusCode());
//                return null;
//            }
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                rawResult= EntityUtils.toString(entity, Charset.forName("utf-8"));
//            }
//        } finally {
//            response.close();
//        }
//        cityWeather = parseTimelineJson(rawResult);
//        cityWeather.setCityName(cityName);
//        return cityWeather;
//    }
//    private CityWeather parseTimelineJson(String rawResult) {
//        CityWeather cityWeather = new CityWeather();
//        if (rawResult==null || rawResult.isEmpty()) {
//            System.out.printf("No raw data%n");
//            return null;
//        }
//        JSONObject timelineResponse = new JSONObject(rawResult);
//        ZoneId zoneId=ZoneId.of(timelineResponse.getString("timezone"));
////        System.out.printf("Weather data for: %s%n", timelineResponse.getString("resolvedAddress"));
//        JSONArray values=timelineResponse.getJSONArray("days");
////        System.out.printf("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
//        for (int i = 0; i < values.length(); i++) {
//            JSONObject dayValue = values.getJSONObject(i);
//            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);
//            double maxtemp=dayValue.getDouble("tempmax");
//            double mintemp=dayValue.getDouble("tempmin");
//            double pop=dayValue.getDouble("precip");
//            cityWeather.setMaxTemp(Double.toString(maxtemp));
//            cityWeather.setMinTemp(Double.toString(mintemp));
//            cityWeather.setPrecip(Double.toString(pop));
////            String source=dayValue.getString("source");
////            System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%s%n", datetime.format(DateTimeFormatter.ISO_LOCAL_DATE), maxtemp, mintemp, pop,source );
//        }
//        return cityWeather;
//    }
//
//    private void mapDtoToEntity(CityWeather cityWeather, CityWeatherDTO cityWeatherDTO) {
//
//        cityWeather.setCityName(cityWeatherDTO.getCityName());
//        cityWeather.setMaxTemp(cityWeatherDTO.getMaxTemp());
//        cityWeather.setMinTemp(cityWeatherDTO.getMinTemp());
//        cityWeather.setPrecip(cityWeatherDTO.getPrecip());
//        cityWeather.setUpdatedTs(cityWeatherDTO.getUpdatedTs());
//        cityWeather.setCreatedTs(cityWeatherDTO.getCreatedTs());
//
//    }
//    private CityWeatherDTO mapEntityToDto(CityWeather cityWeather) {
//        CityWeatherDTO cityWeatherDTO = new CityWeatherDTO();
//        cityWeatherDTO.setCityName(cityWeather.getCityName());
//        cityWeatherDTO.setMaxTemp(cityWeather.getMaxTemp());
//        cityWeatherDTO.setMinTemp(cityWeather.getMinTemp());
//        cityWeatherDTO.setPrecip(cityWeather.getPrecip());
//        cityWeatherDTO.setUpdatedTs(cityWeather.getUpdatedTs());
//        cityWeatherDTO.setCreatedTs(cityWeather.getCreatedTs());
//
//        return cityWeatherDTO;
//    }
}
