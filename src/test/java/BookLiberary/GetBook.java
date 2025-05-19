package BookLiberary;


import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBook {
    String bookID= BookLibraryCrudOps.getBookId();
    @BeforeClass
    public void setup (){
        RestAssured.baseURI="http://216.10.245.166";
    }
    @Test
    public void getBookTest(){
        System.out.println(BookLibraryCrudOps.getBookId());
        String getBookResponse=
                given().
                        when().
                        get("Library/GetBook.php?ID= "+bookID).
                        then().extract().response().asString();
        System.out.println(getBookResponse);
    }

}
