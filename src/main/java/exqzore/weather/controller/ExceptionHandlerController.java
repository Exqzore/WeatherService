package exqzore.weather.controller;

import exqzore.weather.exception.WeatherDataServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(WeatherDataServiceException.class)
  public ResponseEntity<String> handleWeatherDataException(WeatherDataServiceException e) {
    var code = e.getStatusCode();
    return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(code));
  }
}
