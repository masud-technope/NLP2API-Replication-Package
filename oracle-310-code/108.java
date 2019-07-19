JsonReader reader = Json.createReader(new StringReader(personJSONData));
JsonArray personArray = reader.readArray();
reader.close();


for (JsonValue jsonVal : personArray) {
    System.out.println(personObj.getValueType() + " - " 
    + ((JsonObject) personObj).getString("name"));
}