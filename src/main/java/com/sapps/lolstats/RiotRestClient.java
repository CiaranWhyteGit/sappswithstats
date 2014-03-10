package com.sapps.lolstats;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

/*
Last Modified by ciaranwhyte on  07/03/2014 22:15
*/
public class RiotRestClient {

    private final Logger logger = Logger.getLogger(RiotRestClient.class.getName());

    // Gets a JSON String from riots rest api
    public static String getRiotApiString(String requestURL) {
        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return response.getEntity(String.class);
    }

    public String getSummonerId(String summoner_name, String region) throws JSONException {
        String apiRequest = "https://prod.api.pvp.net/api/lol/" + region + "/v1.3/summoner/by-name/" + summoner_name + "?api_key=" + getDevKey();
        //logger.info("Calling " + apiRequest);
        String summonerIdJson = getRiotApiString(apiRequest);
        try {
            return String.valueOf(new JSONObject(summonerIdJson)
                    .getJSONObject(summoner_name)
                    .getInt("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getChampById(int champId) {
        String apiRequest = "https://prod.api.pvp.net/api/lol/static-data/euw/v1/champion/" + String.valueOf(champId) + "?champData=image&api_key=" + getDevKey();
        //logger.info("Calling " + apiRequest);
        String champIdJson = getRiotApiString(apiRequest);
        try {
            return String.valueOf(new JSONObject(champIdJson).get("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //todo: Read this value from a properties file or db
    public String getDevKey() {
        return "6d8a5cf8-f089-45a8-842b-ef123d502da5";
    }
}
