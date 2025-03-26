package SImpleCoursesPrices;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintPurchaseAmount {
    @Test
    public void printPurchaseAmountTest(){
        JsonPath js = new JsonPath(Payload.getCoursesData());
        int purchaseAmount= js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(purchaseAmount,910);
        System.out.println("the purchase amount is "+purchaseAmount);
    }
}
