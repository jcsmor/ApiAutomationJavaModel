package steps;

import io.cucumber.java.en.*;
import pages.ApiWeather;

public class apiWeatherSteps {

    private final ApiWeather apiWeather = new ApiWeather();
    @When("Call current weather data for one location by city name {string}")
    public void callCurrentWeatherDataForOneLocationByCityName(final String cityName) {
        ApiWeather.callByCityName(cityName);
    }

    @Then("the status response code is {int}")
    public void theStatusResponseCodeIs(final int code) {
        ApiWeather.getStatusResponseCode(code);
    }

    @And("the response content type is JSON")
    public void theResponseContentTypeIsJSON() {
        ApiWeather.getContentType();
    }

    @And("the response name equals searched city name {string}")
    public void theResponseNameEqualsSearchedCityName(final String cityName) {
        ApiWeather.getBodyName(cityName);
    }

    @And("the response has a valid temperature")
    public void theResponseHasAValidTemperature() {
        ApiWeather.getTemperature();
    }

    @And("the response min temperature is below or equal max temperature")
    public void theResponseMinTemperatureIsBelowOrEqualMaxTemperature() {
        ApiWeather.compareMinMaxTemp();
    }
}

 /*
        And("Call current weather data for one location by city name (.*)$)", (String word) -> {
            ApiWeather.callByCityName(word);
        });

        And("^(?:Call current weather data for one location by city id (.*)$)", (String id) -> {
            ApiWeather.callByCityID(id);
        });

        Then("^(?:the status response code is (.*)$)", (Integer code) -> {
            ApiWeather.getStatusResponseCode(code);
        });

        Then("^(?:the response content type is JSON$)", () -> {
            ApiWeather.getContentType();
        });

        And("^(?:the response name equals searched city name (.*)$)", (String word) -> {
            ApiWeather.getBodyName(word);
        });

        And("^(?:the body id equals searched city id (.*)$)", (Integer id) -> {
            ApiWeather.getBodyID(id);
        });

        And("^(?:the response has a valid temperature$)", () -> {
            ApiWeather.getTemperature();
        });

        And("^the response min temperature is below or equal max temperature$", () -> {
            ApiWeather.compareMinMaxTemp();
        });


    }

}
*/