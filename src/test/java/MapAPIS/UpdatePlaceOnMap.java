package MapAPIS;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UpdatePlaceOnMap {

    @BeforeClass
    public void setup() {
        // Ensure AddPlaceToMap runs before updating
        AddPlaceToMap addPlace = new AddPlaceToMap();
        addPlace.addPlaceTest(); // Run the add place test first
    }

    @Test
    public void updatePlaceTest() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .body(Payloads.updatePlaceOnMap(AddPlaceToMap.getPlaceID()))
                .when().put("/maps/api/place/update/json")
                .then().assertThat()
                .statusCode(200)
                .body("msg", containsString("success"))
                .extract().response().asString();

        System.out.println(response);
    }
}
