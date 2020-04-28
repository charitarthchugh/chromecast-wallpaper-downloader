package main.java;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject jsonObject= (JsonObject) new JsonParser().parse(new FileReader("src/main/resources/backgrounds.json"));
        JsonArray jsonArray=jsonObject.getAsJsonArray("urls");
        System.out.println((jsonArray==null));
    }
}
