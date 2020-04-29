import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(new FileReader("src/main/resources/backgrounds.json"));
        JsonArray jsonArray = jsonObject.getAsJsonArray("urls");
        String url, fileName;
        ArrayList<String> urlErrors = new ArrayList<String>();
        for (int i = 0; i < jsonArray.size(); i++) {
            url = jsonArray.get(i).getAsJsonObject().get("url").getAsString();
            fileName = "images/" + url.substring(url.lastIndexOf("/") + 1);
            System.out.println(fileName);
            try {
                FileUtils.copyURLToFile(new URL(url), new File(fileName));
            } catch (Exception file) {
                System.out.println("Could not download file at url: \n" + url + "\nfile:" + fileName + "\n ...Skipping file(probably file itself is not available");
                urlErrors.add(url);
            }
        }
        for (String error : urlErrors) {
            System.out.println(error);
        }
        System.out.println("ERROR \n There were errors at the above URLs. This is probably a file that was not able to download. " +
                "Check these files out if you so wish \n All downloaded the files are available in the images folder");
    }
}

