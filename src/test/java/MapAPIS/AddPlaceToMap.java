package MapAPIS;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class AddPlaceToMap {
    private static String placeID;

    public static String getPlaceID() {
        return placeID;
    }

    public static void setPlaceID(String placeID) {
        AddPlaceToMap.placeID = placeID;
    }

    @Test
    public void addPlaceTest() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .body(Payloads.AddPlacePayload())
                .when().post("/maps/api/place/add/json")
                .then().assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        System.out.println(response);

        // Extract Place ID
        JsonPath js = new JsonPath(response);
        placeID = js.getString("place_id");
        System.out.println("The place ID is: " + placeID);
    }
}
