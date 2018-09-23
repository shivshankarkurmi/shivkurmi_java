package com.ubs.assignment;
import com.ubs.assignment.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JsonArray {

    public Object [] getJsonArray(String url) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(url));
        String line = null;
        StringBuilder jsonStrBuilder = new StringBuilder();
        List<JsonObject> JsonObjectArray = new LinkedList<JsonObject>();
        while ((line = br.readLine()) != null) {
            if(line.trim().startsWith("}")) {
                JsonObject jsonObject = new JsonObject();
                String[] jsonStrArray = jsonStrBuilder.toString().replaceAll("\n","").replaceAll("\"","").replaceAll("\\s","").split(",");
                for(String str : jsonStrArray) {
                    String[] keyValuePair = str.split(":");
                    jsonObject.put(keyValuePair[0],keyValuePair[1]);
                }
                JsonObjectArray.add(jsonObject);
                jsonStrBuilder = new StringBuilder();
            } else if (! (line.trim().startsWith("[") || line.trim().startsWith("{"))) {
                      jsonStrBuilder.append(line);
            }
        }
        return JsonObjectArray.toArray();
    }


}
