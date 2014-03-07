package com.sapps.lolstats;

import java.util.logging.Logger;

/**
 * Created by ciaranwhyte on 06/03/2014.
 */
public class Sapp {

    private final Logger logger = Logger.getLogger(this.getClass().toString());
    public String summonerId, region, summoner_name;

    public Sapp(String summoner_name, String region) {
        RiotRestClient riotRestClient = new RiotRestClient();

        this.region = region;
        this.summoner_name = summoner_name;
        this.summonerId = riotRestClient.getSummonerId(summoner_name, region);

        FiveVsFiveRankedStats fiveVsFiveRankedStats = new FiveVsFiveRankedStats(this.summonerId,region,riotRestClient);
        FiveVsFiveUnRankedStats fiveVsFiveUnRankedStats = new FiveVsFiveUnRankedStats(this.summonerId,region,riotRestClient);
        RecentGameStats recentGameStats = new RecentGameStats(this.summonerId,region,riotRestClient);
    }

    public Sapp(String summoner_name) {
        this(summoner_name, "euw");
    }

    public void printDetailsToLog(){
        logger.info("SUMMONER_NAME:" + this.summoner_name +  "SUMMONER_ID: " + this.summonerId);
    }
}
