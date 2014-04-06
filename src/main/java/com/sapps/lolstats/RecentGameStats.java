package com.sapps.lolstats;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.logging.Logger;

/**
 * Created by ciaranwhyte on 07/03/2014.
 */
public class RecentGameStats {
    public final Logger logger = Logger.getLogger(RecentGameStats.class.getName());
    public String summonerId, region, lastTenGames;
    public RiotRestClient riotRestClient;
    public int championId, wins = 0, losses = 0;


    public RecentGameStats(String summonerId, String region, RiotRestClient riotRestClient) throws Exception {
        this.summonerId = summonerId;
        this.region = region;
        this.riotRestClient = riotRestClient;
        JSONArray recentGameStats = new JSONObject(getRecentGameStats()).getJSONArray("games");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recentGameStats.length(); i++) {
            JSONObject game = recentGameStats.getJSONObject(i);
            this.championId = game.getInt("championId");

            if (game.getJSONObject("stats").getBoolean("win")) wins++;
            else losses++;

            sb.append("<p>Champion Name: " + riotRestClient.getChampById(this.championId) + "\n\tWin: " + String.valueOf(wins) + "\n\tLosses: " + String.valueOf(losses) + "</p>");
        }
        this.lastTenGames = sb.toString();
    }

    public String getRecentGameStats() {
        String apiRequest = "https://prod.api.pvp.net/api/lol/" + this.region + "/v1.3/game/by-summoner/" + this.summonerId + "/recent?api_key=" + riotRestClient.getDevKey();
        String recentGameStatsJson = RiotRestClient.getRiotApiString(apiRequest);
        return recentGameStatsJson;
    }
}
