package com.sapps.lolstats;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

/**
 * Created by ciaranwhyte on 07/03/2014.
 */
public class RecentGameStats {
    private final Logger logger = Logger.getLogger(RecentGameStats.class.getName());
    private String summonerId, region;
    private RiotRestClient riotRestClient;

    public RecentGameStats(String summonerId, String region, RiotRestClient riotRestClient) throws JSONException {
        this.summonerId = summonerId;
        this.region = region;
        this.riotRestClient = riotRestClient;
        try {
            getRecentGameStats(summonerId, region);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getRecentGameStats(String summonerId, String region) throws JSONException {
        String apiRequest = "https://prod.api.pvp.net/api/lol/" + region + "/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=" + riotRestClient.getDevKey();
        logger.warning("Calling " + apiRequest);
        String recentGameStatsJson = riotRestClient.getRiotApiString(apiRequest);
        logger.warning(recentGameStatsJson);
        try {
            return String.valueOf(new JSONObject(recentGameStatsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
