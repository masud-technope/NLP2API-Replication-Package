import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
 
public class Main {
    public static void main(String[] args) {
        String personJSONData = 
            "  {" +
            "   \"name\": \"Jack\", " +
            "   \"age\" : 13, " +
            "   \"isMarried\" : false, " +
            "   \"address\": { " +
            "     \"street\": \"#1234, Main Street\", " +
            "     \"zipCode\": \"123456\" " +
            "   }, " +
            "   \"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"] " +
            " }";
         
        JsonReader reader = Json.createReader(new StringReader(personJSONData));
         
        JsonObject personObject = reader.readObject();
         
        reader.close();
         
        System.out.println("Name   : " + personObject.getString("name"));
        System.out.println("Age    : " + personObject.getInt("age"));
        System.out.println("Married: " + personObject.getBoolean("isMarried"));

        JsonObject addressObject = personObject.getJsonObject("address");
        System.out.println("Address: ");
        System.out.println(addressObject.getString("street"));
        System.out.println(addressObject.getString("zipCode"));
         
        System.out.println("Phone  : ");
         JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
        for (JsonValue jsonValue : phoneNumbersArray) {
            System.out.println(jsonValue.toString());
        }
    }
}