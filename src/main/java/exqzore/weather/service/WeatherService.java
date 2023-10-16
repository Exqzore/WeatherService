package exqzore.weather.service;

import exqzore.weather.domain.WeatherData;
import exqzore.weather.exception.WeatherDataServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private final RestTemplate restTemplate;

  @Value("${app.weather.api-key}")
  private String apiKey;

  @Value("${app.weather.url}")
  private String url;

  public WeatherData getWeatherDataForCity(String city) {
    if (city.isBlank()) {
      throw new WeatherDataServiceException(HttpStatus.BAD_REQUEST.value(), "City name is blank");
    }

    var apiUrl = String.format(url, city, apiKey);

    try {
      return restTemplate.getForObject(apiUrl, WeatherData.class);
    } catch (HttpClientErrorException e) {
      throw new WeatherDataServiceException(e.getStatusCode().value(), e.getMessage());
    }
  }
}
