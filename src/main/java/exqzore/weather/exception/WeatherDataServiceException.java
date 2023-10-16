package exqzore.weather.exception;

import lombok.Getter;

@Getter
public class WeatherDataServiceException extends RuntimeException {

  private final int statusCode;

  public WeatherDataServiceException(int statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }
}
