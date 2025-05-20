package DataFakerDemoTwo;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GenerateFakeDataDemo {
    public static void main(String[] args) {
        Faker faker = new Faker();

        String fakeName = faker.name().fullName();
        String saudiFakePhone = "+9665" + faker.number().numberBetween(10000000, 99999999);
        //arabic local lang
       Locale arabicLocal=new Locale.Builder().setLanguage("ar").build();
       //arabic faker
        Faker arabicFaker=new Faker(arabicLocal);
        String arabicName=arabicFaker.name().fullName();
        System.out.println("arabic name"+arabicName);
        System.out.println("Fake Name: " + fakeName);
        System.out.println("Fake Saudi Phone: " + saudiFakePhone);
        System.out.println("Arabic Name: " + arabicName);
        Map<String,Object> fakeUserData= new HashMap<>();
        fakeUserData.put("name",faker.name().fullName());
        fakeUserData.put("age",faker.number().numberBetween(16,30));
        fakeUserData.put("email",faker.internet().emailAddress());
        fakeUserData.put("phone","+9665"+faker.number().numberBetween(10000000,99999999));
        //jackson object mapper  for wrtite json
        ObjectMapper mapper =new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("D:/compressed/fakeUser.json"),fakeUserData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
