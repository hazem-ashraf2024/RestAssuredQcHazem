package BookLiberary;



import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBook {
    @BeforeClass
    public void setup (){
        RestAssured.baseURI="http://216.10.245.166";
    }
    @Test
    public void DeleteBookTest(){
        String getBookResponse=
                given().log().all().body("{\n" +
                        " \n" +
                        "\"ID\" : \""+AddBook.getBookId()+"\"\n" +
                        " \n" +
                        "} \n").when().
                        post(":/Library/DeleteBook.php").
                        then().log().all().extract().response().asString();
        System.out.println(getBookResponse);
    }

}
