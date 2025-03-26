package MapAPIS;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPlaceOnMap {

    @BeforeClass // Runs once before all tests
    public void addPlace() {
        AddPlaceToMap addPlace = new AddPlaceToMap();
        addPlace.addPlaceTest(); // Call the new @Test method in AddPlaceToMap
    }

    @Test
    public void updatePlace() {
        UpdatePlaceOnMap updatePlace = new UpdatePlaceOnMap();
        updatePlace.updatePlaceTest(); // Call the new @Test method in UpdatePlaceOnMap
    }

    @Test(dependsOnMethods = "updatePlace") // Ensures update runs before get
    public void verifyUpdatedAddress() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", AddPlaceToMap.getPlaceID())
                .when().get("/maps/api/place/get/json")
                .then().assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String newAddress = js.getString("address");

        // Validate the updated address
        Assert.assertEquals(newAddress, "70 Summer walk, USA", "Address did not update correctly!");
    }
}
