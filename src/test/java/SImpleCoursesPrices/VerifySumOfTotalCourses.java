package SImpleCoursesPrices;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class VerifySumOfTotalCourses {
    int purchaseAmount;
    List<Integer>pricesList;
    List<Integer> copyiesList;
    int sum;
    @BeforeClass
    public void setup(){
        //parse string to json
        JsonPath js= new JsonPath(Payload.getCoursesData());
        // get purchase actual
        purchaseAmount=js.getInt("dashboard.purchaseAmount");
        // get list of prices
        pricesList =js.getList("courses.price");
        // get number of copies
        copyiesList=js.getList("courses.copies");
        // get sum of prices
        for (int i = 0; i < pricesList.size() ; i++) {

            sum+=(pricesList.get(i)*copyiesList.get(i));
        }
    }
    @Test
    public void SumMatchPurchaseAmount(){
        // asssert that sum of prices = purchase amount
        Assert.assertEquals(sum,purchaseAmount);
    }
}
