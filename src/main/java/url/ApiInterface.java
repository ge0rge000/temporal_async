package url;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
public class ApiInterface {

    public static void main(String[ ] args){
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpResponse response=null;
        try{
            String endPoint="http://data.fixer.io/api/latest?access_key=e32dbc0bada6ce316c659ff029d0673d&format=1";
            URI uri = URI.create(endPoint+"?foo=bar&foo2=bar2");
            HttpRequest request =HttpRequest.newBuilder().uri(uri).build();
            response=client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            e.printStackTrace();
        }
        Object obj=JSONValue.parse((String) response.body());
        JSONObject cuurrency = (JSONObject) obj;

        JSONObject ratess = (JSONObject) cuurrency.get("rates");

        System.out.println("EGP:"+ratess.get("EGP"));
        System.out.println("USD:"+ratess.get("USD"));



    }

}
