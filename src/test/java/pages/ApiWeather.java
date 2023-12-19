//package pages;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.*;
//
//
//public class ApiWeather
//{
//    private static Response response;
//    private static ValidatableResponse json;
//    private static RequestSpecification request;
//    private static String ENDPOINT = "http://api.openweathermap.org/data/2.5/weather";
//    private static String API_KEY = "e3b6412a251b21dce388ea59d0b69762";
//
//
//    public static void callByCityName(String city) {
//        request = given().param("q", city).param("APPID", API_KEY);
//        response = request.when().get(ENDPOINT);
//    }
//
//    public static void getStatusResponseCode(Integer statusCode) {
//        response.then().statusCode(statusCode);
//    }
//
//    public static void getContentType() {
//        response.then().contentType(ContentType.JSON);
//    }
//
//    public static void getBodyName(String city) {
//        response.then().body("name", equalTo(city));
//    }
//
//    public static void getBodyID(Integer id) {
//        response.then().body("id", equalTo(id));
//    }
//
//    public static void callByCityID(String id) {
//        request = given().param("id", id).param("APPID", API_KEY);
//        response = request.when().get(ENDPOINT);
//    }
//
//    public static void getTemperature(){
//        String result = response.path("main.temp").toString();
//        Double dResult = Double.valueOf(result);
//        assertThat(dResult, instanceOf(Double.TYPE));
//    }
//
//    public static void compareMinMaxTemp(){
//        Float tempMin = response.path("main.temp_min");
//        Float tempMax = response.path("main.temp_max");
//        assertThat(tempMax, is(greaterThanOrEqualTo(tempMin)));
//    }
//
//}
