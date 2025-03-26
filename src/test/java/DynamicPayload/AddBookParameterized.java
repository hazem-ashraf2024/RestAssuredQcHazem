package DynamicPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class AddBookParameterized {
    private String bookID;
    private String isbn="qchazem";
    private String aisle="2025";
    @BeforeClass
    public void setup(){

        RestAssured.baseURI="http://216.10.245.166";
        // string response
        String addBookResponse=given().log().all()
                .header("Content-Type","application/json")
                .body(ParameterizedPayload.AddBook(isbn,aisle))
                .when().post("Library/Addbook.php")
                .then().log().all().extract().response().asString();
        //pasre to json
        JsonPath js= new JsonPath(addBookResponse);
        // getting book id
        bookID=js.getString("ID");
    }
    @Test
    public void addBookTest(){
        Assert.assertEquals(bookID,isbn+aisle);
    }

}
