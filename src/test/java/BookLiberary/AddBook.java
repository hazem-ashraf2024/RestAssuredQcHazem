package BookLiberary;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jdk.jfr.RecordingState;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AddBook {
    private static String bookId;

    public static String getBookId() {
        return bookId;
    }

    @BeforeClass
    public void setup(){

        RestAssured.baseURI="http://216.10.245.166";
    }
    @Test
    public void addBookTest(){
        try {
            String addBookResponse=given().log().all().header("Content-Type","application/json")
                    .body(new String(Files.readAllBytes(Paths.get("D:\\restApi-rahulShetty\\1\\1\\07 - Handling Dynamic Json Payloads with Parameterization\\addBook.json"))))
                    .when().post("Library/Addbook.php")
                    .then().log().all().extract().response().asString();
            JsonPath js=new JsonPath(addBookResponse);
             bookId=js.getString("ID");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("the book id is "+bookId);
    }

    @Test(dependsOnMethods = "addBookTest")
    public void getBookTest(){
        System.out.println(AddBook.getBookId());
        String getBookResponse=
                given().
                        when().
                        get("Library/GetBook.php?ID= "+bookId+"").
                        then().extract().response().asString();
        System.out.println(getBookResponse);
    }
    @Test(dependsOnMethods = "getBookTest")
    public void DeleteBookTest(){
        String getBookResponse=
                given().log().all().body("{\n" +
                                " \n" +
                                "\"ID\" : \""+bookId +
                                " \n" +
                                "} \n").when().
                        post(":/Library/DeleteBook.php").
                        then().log().all().extract().response().asString();
        System.out.println(getBookResponse);
    }

}
