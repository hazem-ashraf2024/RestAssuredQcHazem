package SImpleCoursesPrices;

public class Payload {
    //getter method for the payload
    public static String getCoursesData() {
        return coursesData;
    }
// my payload for trainnig
    private static String coursesData="{\n" +
            "  \"dashboard\": {\n" +
            "    \"purchaseAmount\": 910,\n" +
            "    \"website\": \"rahulshettyacademy.com\"\n" +
            "  },\n" +
            "  \"courses\": [\n" +
            "    {\n" +
            "      \"title\": \"Selenium Python\",\n" +
            "      \"price\": 50,\n" +
            "      \"copies\": 6\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Cypress\",\n" +
            "      \"price\": 40,\n" +
            "      \"copies\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"RPA\",\n" +
            "      \"price\": 45,\n" +
            "      \"copies\": 10\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";
}
