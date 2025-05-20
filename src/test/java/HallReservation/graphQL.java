package HallReservation;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class graphQL {

    @Test
    public void testQraphQLTrial(){
        String query = " ";
        RestAssured.baseURI="\"https://bahrain-project.kickstartinteractive.net/graphql\"";

        given().log().all().contentType("application/json")
                .body(query).when().post()
                .then().log().all().assertThat().statusCode(200);
    }
}
