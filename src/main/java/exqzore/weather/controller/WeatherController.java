package exqzore.weather.controller;

import exqzore.weather.domain.WeatherData;
import exqzore.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WeatherController {

  private final WeatherService weatherService;

  @GetMapping("/weather")
  public WeatherData getWeather(@RequestParam String city) {
    return weatherService.getWeatherDataForCity(city);
  }
}
