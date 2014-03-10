package com.sapps.lolstats;

import org.json.JSONArray;
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
    private int championId, wins = 0, losses = 0;

    public RecentGameStats(String summonerId, String region, RiotRestClient riotRestClient) throws JSONException {
        this.summonerId = summonerId;
        this.region = region;
        this.riotRestClient = riotRestClient;
        JSONArray recentGameStats = new JSONObject(getRecentGameStats()).getJSONArray("games");

        for (int i = 0; i < recentGameStats.length(); i++) {
            JSONObject game = recentGameStats.getJSONObject(i);
            this.championId = game.getInt("championId");

            if (game.getJSONObject("stats").getBoolean("win")) wins++;
            else losses++;

            logger.info("\n\n\tChampion Name: " + riotRestClient.getChampById(this.championId) + "\n\tWin: " + String.valueOf(wins) + "\n\tLosses: " + String.valueOf(losses) + "\n");
        }
    }

    public String getRecentGameStats() {
        String apiRequest = "https://prod.api.pvp.net/api/lol/" + this.region + "/v1.3/game/by-summoner/" + this.summonerId + "/recent?api_key=" + riotRestClient.getDevKey();
        //logger.info("Calling " + apiRequest);
        String recentGameStatsJson = RiotRestClient.getRiotApiString(apiRequest);
        //logger.info(recentGameStatsJson);
        return recentGameStatsJson;
    }
}
