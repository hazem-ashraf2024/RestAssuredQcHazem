package GetCourseDetails_Secured_OAtuth;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationServerEndPointTest {
    protected static String token;
    String authorizationServer="https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
    @Test
    public void getToken(){
        final String clientID="692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
        final String clientSecret="erZOWM9g3UtwNRj340YYaK_W";
        final String grantType="client_credentials";
        final String scope="trust";
        String response =given()
                .formParam("client_id",clientID)
                .formParam("client_secret",clientSecret)
                .formParam("grant_type",grantType)
                .formParam("scope",scope)
                .when().post(authorizationServer).
                then().log().all().extract().response().asString();
        System.out.println(response);
        JsonPath js= new JsonPath(response);
        token=js.getString("access_token");
        System.out.println("the token is: "+token);
    }


}
