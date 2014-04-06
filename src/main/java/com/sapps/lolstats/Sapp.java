package com.sapps.lolstats;

import java.util.logging.Logger;

/**
 * Created by ciaranwhyte on 06/03/2014.
 */
public class Sapp {

    private final Logger logger = Logger.getLogger(RiotRestClient.class.getName());
    public String summonerId, region, summoner_name;
    public FiveVsFiveRankedStats fiveVsFiveRankedStats;
    public FiveVsFiveUnRankedStats fiveVsFiveUnRankedStats;
    public RecentGameStats recentGameStats;

    public Sapp(String summoner_name, String region) throws Exception {
        RiotRestClient riotRestClient = new RiotRestClient();
        this.region = region;
        this.summoner_name = summoner_name;
        this.summonerId = riotRestClient.getSummonerId(summoner_name, region);
        this.fiveVsFiveRankedStats = new FiveVsFiveRankedStats(this.summonerId, region, riotRestClient);
        this.fiveVsFiveUnRankedStats = new FiveVsFiveUnRankedStats(this.summonerId, region, riotRestClient);
        this.recentGameStats = new RecentGameStats(this.summonerId, region, riotRestClient);
    }

    public Sapp(String summoner_name) throws Exception {
        this(summoner_name, "euw");
    }

    public void printDetailsToLog() {
        logger.info("SUMMONER_NAME:" + this.summoner_name);
        logger.info("SUMMONER_ID: " + this.summonerId);
    }
}
