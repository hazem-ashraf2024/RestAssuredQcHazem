package SImpleCoursesPrices;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CopiesForRpaCourse {
    int indexOfRpaCourse=-1;
    boolean flag= false;
    int priceForRpaCourse;
    @BeforeClass
    public void setup(){
        // parse string to json

        JsonPath js= new JsonPath(Payload.getCoursesData());
        List<String> courseTitles=js.getList("courses.title");
        for (int i = 0; i < courseTitles.size() && !flag; i++) {
            if(courseTitles.get(i).equalsIgnoreCase("rpa")){
                indexOfRpaCourse=i;
                flag =true;
            }
            }
        List<Integer>coursePrices=js.getList("courses.price");
        priceForRpaCourse= coursePrices.get(indexOfRpaCourse);
        }
        @Test
    public void RpaPrice(){
            Assert.assertEquals(priceForRpaCourse,45);
    }
}
