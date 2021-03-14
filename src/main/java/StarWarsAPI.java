import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;



public class StarWarsAPI {

    public ArrayList<Character> getAllStarWarsCharacterAsJson() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ArrayList<Character> characters = new ArrayList<Character>();

        try {

            HttpGet request = new HttpGet("https://swapi.dev/api/people/");


            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode arrayNode = mapper.readTree(result).get("results");
                    for (JsonNode node: arrayNode){
                        String name = node.get("name").asText();
                        String height = node.get("height").asText();
                        String year = node.get("birth_year").asText();
                        Character character = new Character(name,height,year);
                        characters.add(character);

                    }

                    for (Character character: characters){
                        System.out.println(character.toString());
                    }



                }

            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }

        return characters;
    }

}
