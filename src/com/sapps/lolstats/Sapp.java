package com.sapps.lolstats;

/**
 * Created by ciaranwhyte on 06/03/2014.
 */
public class Sapp {

    public String summonerId, region;

    public Sapp(String summoner_name, String region) {
        this.region = region;
        this.summonerId = getSummonerId(summoner_name, region);
        FiveVsFiveRankedStats fiveVsFiveRankedStats = new FiveVsFiveRankedStats(this.summonerId,region);
        FiveVsFiveUnRankedStats fiveVsFiveUnRankedStats = new FiveVsFiveUnRankedStats();
    }

    private String getSummonerId(String summoner_name, String region) {
        return null;
    }
}
