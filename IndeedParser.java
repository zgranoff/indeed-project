import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
//https://github.com/easiestripes/IndeedParser.git
public class IndeedParser {

    public static void main(String[] args) throws Exception {

        // Indeed API call
        String indeed_api_key = "YOUR INDEED API KEY";
        String query = "JOB TITLE TO SEARCH FOR";
        int total_results = 1000;

        String api_request_url;
        int results_left = total_results;
        int start = 0, limit = Math.min(results_left, 25); // Indeed seems to have a cap of 25 results per request
        Client client = ClientBuilder.newClient();

        while(results_left > 0) {
            // Add any other API requst params to the string below
            api_request_url = "http://api.indeed.com/ads/apisearch?publisher=" + indeed_api_key + "&q=" + query.replaceAll("\\s", "+") + "&start=" + start + "&limit=" + limit +"&format=json&v=2";

            WebTarget resource = client.register(JsonProcessingFeature.class).target(api_request_url);

            Invocation.Builder request = resource.request(MediaType.APPLICATION_JSON);
            Response response = request.get();

            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode resultsArr = mapper.readTree(response.readEntity(String.class)).get("results");

                ArrayList<String> job_urls = new ArrayList<>();

                for (JsonNode node : resultsArr) {
                    job_urls.add(node.get("url").textValue());
                }

                ArrayList<String> job_descriptions = new ArrayList<>();

                // Scrape full job description from the job's html page
                for (String url : job_urls) {
                    Document doc = Jsoup.connect(url).get();
                    Elements job_elements = doc.select("#job_summary");
                    String job_plaintext = job_elements.text();
                    job_descriptions.add(job_plaintext);
                }

                // Write job descriptions to a txt file
                try {
                    String desc_dir_path = "RELATIVE PATH TO LOCAL DIRECTORY";

                    String file_name = query.trim().replaceAll("\\s+", "_").toLowerCase();

                    Path job_descr_file = Paths.get(desc_dir_path + file_name + ".txt");
                    if (Files.exists(job_descr_file)) {
                        Files.write(job_descr_file, job_descriptions, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                    } else {
                        Files.write(job_descr_file, job_descriptions, Charset.forName("UTF-8"));
                    }
                } catch (IOException e) {
                    System.out.println("File failed to write");
                    e.printStackTrace();
                }
            } else {
                System.out.println("HTTP request failed, returning status code " + response.getStatus());
            }

            start += limit;
            results_left -= limit;
            limit = Math.min(results_left, 25);
        }
    }
}
