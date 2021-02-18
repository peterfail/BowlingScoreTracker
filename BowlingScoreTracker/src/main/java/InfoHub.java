import org.json.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class InfoHub {

    public static void main(String[] args) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://13.74.31.101/api/points";
        BowlingPoints bowlingPoints = restTemplate.getForObject(url, BowlingPoints.class);

        //System.out.println(bowlingPoints.toString());

        JSONObject json = new JSONObject();
        json.put("token",bowlingPoints.getToken());

        int[] points = bowlingPoints.getSum();
        JSONArray array = new JSONArray();
        for (int i:
             points) {
            array.put(i);
        }
        json.put("points",array);

        System.out.println(json.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(),headers);

        //String response = restTemplate.postForObject(url, entity, String.class);
        //System.out.println(response.toString());
    }
}
