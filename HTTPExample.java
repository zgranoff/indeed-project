//http://chillyfacts.com/java-send-http-getpost-request-and-read-json-response/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }

public static void call_me() throws Exception {
  //Input where Indeed API with different Parameters would have been inputed
     String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Return Values that would have been received
     JSONObject myResponse = new JSONObject(response.toString());
     System.out.println("result after Reading JSON Response");
     System.out.println("statusCode- "+myResponse.getString("statusCode"));
     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
     System.out.println("countryCode- "+myResponse.getString("countryCode"));
     System.out.println("countryName- "+myResponse.getString("countryName"));
     System.out.println("regionName- "+myResponse.getString("regionName"));
     System.out.println("cityName- "+myResponse.getString("cityName"));
     System.out.println("zipCode- "+myResponse.getString("zipCode"));
     System.out.println("latitude- "+myResponse.getString("latitude"));
     System.out.println("longitude- "+myResponse.getString("longitude"));
     System.out.println("timeZone- "+myResponse.getString("timeZone"));
   }
}
