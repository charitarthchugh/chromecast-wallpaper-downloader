import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class test {
    public static void main(String[] args) throws Exception {
        JsonObject jsonObject= (JsonObject) new JsonParser().parse(new FileReader("src/test/resources/test.json"));
        JsonArray jsonArray=jsonObject.getAsJsonArray("urls");
        Assert.assertNotNull(jsonArray);
        String url, fileName;
        for(int i=0;i<jsonArray.size();i++){
            url=jsonArray.get(i).getAsJsonObject().get("url").getAsString();
            fileName="images/"+url.substring(url.lastIndexOf("/")+1);
            System.out.println(fileName);
            try {
                FileUtils.copyURLToFile(new URL(url),new File(fileName));
            }catch (FileNotFoundException file){
                System.out.println("Could not download file at url: \n"+url+"\nfile:" +fileName+"\n ...Skipping file(probably file itself is not available");
            }
        }
    }
}
