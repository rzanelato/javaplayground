package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class LerPaginaWeb {



    public static void main(String[] args) throws IOException, InterruptedException {
        //System.setProperty("http.proxyHost", "10.129.8.100");
        //System.setProperty("http.proxyPort", "8080");

        executeByURL();


    }
    
    private static void executeHttp() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://es.yahoo.com/?p=us"))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        
    }
   
    

    private static void executeByURL() throws IOException {
        BufferedReader br = null;

        try {

            URL url = new URL("https://es.yahoo.com/?p=us");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                //sb.append("\n");
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

}
