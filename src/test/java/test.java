package test.java;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject jsonObject= (JsonObject) new JsonParser().parse(new FileReader("src/test/resources/test.json"));
        JsonArray jsonArray=jsonObject.getAsJsonArray("urls");
        System.out.println((jsonArray==null));
        for(int i=0;i<jsonArray.size();i++){

        }
    }
}
