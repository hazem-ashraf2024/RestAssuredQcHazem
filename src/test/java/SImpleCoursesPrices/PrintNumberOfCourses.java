package SImpleCoursesPrices;

import MapAPIS.Payloads;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintNumberOfCourses {
    @Test
    public void NumberOfCourses(){
        // step one parsing string to json
        JsonPath js=new JsonPath(Payload.getCoursesData());
        // step 2 extracting number of courses
        int numberOfCourses=js.getInt("courses.size()");
        // assert that actual is the expected
        Assert.assertEquals(numberOfCourses,3);
        System.out.printf("the number of courses is "+numberOfCourses);
    }
}
