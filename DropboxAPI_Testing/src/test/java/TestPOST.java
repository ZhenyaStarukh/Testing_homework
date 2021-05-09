import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestPOST {

    private void getAndSavePic() throws IOException {
        URL url = new URL("https://cdn.shopify.com/s/files/1/0035/2754/0782/articles/International_Flower_Day_1200x1200.jpeg");
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] res = out.toByteArray();
        FileOutputStream fos = new FileOutputStream("image.jpeg");
        fos.write(res);
        fos.close();
    }

    @Test
    public void Atest_upload() throws IOException {

        getAndSavePic();

        JSONObject apiArg = new JSONObject();
        apiArg.put("mode","add");
        apiArg.put("autorename", true);
        apiArg.put("path","/test/pic.jpg");

        File file = new File("image.jpeg");


        RestAssured.given()
                .headers("Dropbox-API-Arg",apiArg.toJSONString(),
                        "Content-Type","text/plain; charset=dropbox-cors-hack",
                        "Authorization", "Bearer 6plD-R50KVgAAAAAAAAAAelGaPYw6K0LzcHH2rOlr6iBya77vhQdhN6KN4" +
                        "dUCdTz")
                .body(FileUtils.readFileToByteArray(file))
                .when().post("https://content.dropboxapi.com/2/files/upload")
                .then().statusCode(200);

        file.delete();
    }

    @Test
    public void Btest_getMetadata(){
        JSONObject requestParam = new JSONObject();
        requestParam.put("path","/test/pic.jpg");
        requestParam.put("include_media_info",true);

       RestAssured.given()
                .headers("Authorization", "Bearer 6plD-R50KVgAAAAAAAAAAelGaPYw6K0LzcHH2rOlr6iBya77vhQdhN6KN4" +
                        "dUCdTz",
                        "Content-Type","application/json")
                .body(requestParam.toJSONString())
                .when().post("https://api.dropboxapi.com/2/files/get_metadata")
                .then().statusCode(200);
    }

    @Test
    public void Ctest_delete(){
        JSONObject requestParam = new JSONObject();
        requestParam.put("path","/test/pic.jpg");

        RestAssured.given()
                .headers("Authorization", "Bearer 6plD-R50KVgAAAAAAAAAAelGaPYw6K0LzcHH2rOlr6iBya77vhQdhN6KN4" +
                                "dUCdTz",
                        "Content-Type","application/json")
                .body(requestParam.toJSONString())
                .when().post("https://api.dropboxapi.com/2/files/delete_v2")
                .then().statusCode(200);

    }

}
