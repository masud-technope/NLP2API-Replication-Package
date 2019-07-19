import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
 
public class Main {
     
    public static void main(String[] args) {
        JsonObject personObject = Json.createObjectBuilder()
                .add("name", "Jack")
                .add("age", 13)
                .add("isMarried", false)
                .add("address", 
                     Json.createObjectBuilder().add("street", "Main Street")
                                               .add("city", "New York")
                                               .add("zipCode", "11111")
                                               .build()
                    )
                .add("phoneNumber", 
                     Json.createArrayBuilder().add("00-000-0000")
                                              .add("11-111-1111")
                                              .add("11-111-1112")
                                              .build()
                    )
                .build();
         
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        writer.writeObject(personObject);
        writer.close();
        System.out.println(stringWriter.getBuffer().toString());
    }
 
}