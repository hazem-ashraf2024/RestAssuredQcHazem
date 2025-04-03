package GetCourseDetails_Secured_OAtuth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCourseDetailsTest {
    @Test(dependsOnMethods = "GetCourseDetails_Secured_OAtuth.AuthorizationServerEndPointTest.getToken")
            public void courseDetailes() {
            String courseDetails = given().queryParam("access_token", AuthorizationServerEndPointTest.token)
                    .when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
            System.out.println(courseDetails);

    }

}
