package DynamicPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddBookDataProvider {
    private final List<String> bookIDs = new ArrayList<>(); // Store book IDs

    @Test(dataProvider = "addBookData")
    public void addBookTest(String aisle, String isbn) {
        RestAssured.baseURI = "http://216.10.245.166";

        // Sending request and getting response
        String addBookResponse = given().header("Content-Type", "application/json")
                .body(ParameterizedPayload.AddBook(isbn, aisle))
                .when().post("Library/Addbook.php")
                .then().extract().response().asString();

        // Parsing string to JSON
        JsonPath js = new JsonPath(addBookResponse);
        String bookID = js.getString("ID");

        // Check if book ID is valid and store it
        if (bookID == null || bookID.isEmpty()) {
            System.err.println("Book ID is empty for ISBN: " + isbn + " and Aisle: " + aisle);
        } else {
            bookIDs.add(bookID);
            System.out.println("Stored Book ID: " + bookID);
        }
    }

    @Test(dependsOnMethods = "addBookTest")
    public void verifyStoredBookIDs() {
        System.out.println("All Stored Book IDs: " + bookIDs);
        Assert.assertFalse(bookIDs.isEmpty(), "bookIDs list is empty, no books were added!");
    }

    @DataProvider(name = "addBookData")
    public Object[][] bookdata() {
        return new Object[][]{
                {"qc11", "12"},
                {"qc21", "13"},
                {"qc31", "14"}
        };
    }
}
