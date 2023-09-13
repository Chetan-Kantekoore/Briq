package Selenium_Web_Table;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIToCSV {
    public static void main(String[] args) throws IOException {
       
        String apiUrl = "https://data.sfgov.org/resource/p4e4-a5a7.json";

        
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

        
        HttpResponse response = httpClient.execute(httpGet);

     
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getEntity().getContent());

        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
        String timestamp = dateFormat.format(new Date());
        System.out.println("Current Timestamp: " + timestamp);

        
        for (JsonNode node : jsonNode) {
            System.out.println("ID: " + node.get("id"));
            System.out.println("Name: " + node.get("name"));
       
            System.out.println("--------------------------");
        }

        
        Pattern pattern = Pattern.compile(".*roof.*", Pattern.CASE_INSENSITIVE);
        for (JsonNode node : jsonNode) {
            String text = node.toString();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.println("Line related to 'roof': " + text);
            }
        }
    }
}
