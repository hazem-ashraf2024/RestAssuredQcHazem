package SImpleCoursesPrices;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class PrintAllCourseTitlesWithRespectivePrices {
    List<String> courseTitles;
    List<Integer> coursePrices;
    @BeforeClass
    public void setup() {
        JsonPath js = new JsonPath(Payload.getCoursesData());
        courseTitles = js.getList("courses.title");
        coursePrices=js.getList("courses.price");
        for (int i = 0; i < courseTitles.size(); i++) {
            System.out.println("course of title "+courseTitles.get(i)+" it's price is $"+coursePrices.get(i));

        }

    }

    @Test
    public void testFirstCourseTitle() {
        System.out.println("Verifying the first course title...");
        Assert.assertEquals(courseTitles.get(0), "Selenium Python", "First course title mismatch!");
    }

    @Test
    public void testSecondCourseTitle() {
        System.out.println("Verifying the second course title...");
        Assert.assertEquals(courseTitles.get(1), "Cypress", "Second course title mismatch!");
    }

    @Test
    public void testRPAExists() {
        System.out.println("Checking if 'RPA' exists in the list...");
        Assert.assertTrue(courseTitles.contains("RPA"), "RPA not found!");
    }
}
