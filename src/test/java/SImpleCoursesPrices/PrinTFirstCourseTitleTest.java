package SImpleCoursesPrices;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class PrinTFirstCourseTitleTest {
        @Test
        public void prinFirstCourseTitleTest(){
            JsonPath js = new JsonPath(Payload.getCoursesData());
            String firstCourseTitle= js.getString("courses[0].title");
            Assert.assertEquals(firstCourseTitle,"Selenium Python");
        }
    }

