package DynamicPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.*;

public class AddBookWithJsonFile {
    @Test
    public void addMultipleBooks() {
        RestAssured.baseURI = "http://216.10.245.166";

        String jsonData;
        try {
            // Read the JSON file containing multiple book objects
            jsonData = new String(Files.readAllBytes(Paths.get("D:\\restApi-rahulShetty\\1\\1\\07 - Handling Dynamic Json Payloads with Parameterization\\addBook.json")));

            // Convert JSON string to a List of objects
            JsonPath jsonPath = new JsonPath(jsonData);
            List<Object> books = jsonPath.getList("");

            // Iterate over each book object and send a request
            for (Object book : books) {
                String addBookResponse = given().log().all()
                        .header("Content-Type", "application/json")
                        .body(book) // Send individual book JSON
                        .when().post("Library/Addbook.php")
                        .then().log().all().extract().response().asString();

                // Parse response to get book ID
                JsonPath responseJs = new JsonPath(addBookResponse);
                String bookID = responseJs.getString("ID");
                System.out.println("\n Book ID is: \n" + bookID);
            }

        } catch (IOException e) {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }
    }
}
