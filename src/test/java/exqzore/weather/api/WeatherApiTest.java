package exqzore.weather.api;

import static org.hamcrest.Matchers.containsString;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherApiTest {

  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8080;
  }

  @Test
  public void testGetWeather() {
    String city = "Minsk";
    RestAssured.given()
        .param("city", city)
        .when()
        .get("/weather")
        .then()
        .statusCode(200);
  }

  @Test
  public void testGetWeatherForBlankCityName() {
    String city = "";
    RestAssured.given()
        .param("city", city)
        .when()
        .get("/weather")
        .then()
        .statusCode(400)
        .body(containsString("City name is blank"));
  }

  @Test
  public void testGetWeatherForUnrealCityName() {
    String city = "XXX";
    RestAssured.given()
        .param("city", city)
        .when()
        .get("/weather")
        .then()
        .statusCode(404)
        .body(containsString("city not found"));
  }
}
