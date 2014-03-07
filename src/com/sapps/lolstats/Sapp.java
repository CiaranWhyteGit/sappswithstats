package com.sapps.lolstats;

/**
 * Created by ciaranwhyte on 06/03/2014.
 */
public class Sapp {
    public String summonerId, region, summoner_name;

    public Sapp(String summoner_name, String region) {
        this.region = region;
        this.summoner_name = summoner_name;
        this.summonerId = getSummonerId(summoner_name, region);
        FiveVsFiveRankedStats fiveVsFiveRankedStats = new FiveVsFiveRankedStats(this.summonerId,region);
        FiveVsFiveUnRankedStats fiveVsFiveUnRankedStats = new FiveVsFiveUnRankedStats(this.summonerId,region);
        RecentGameStats recentGameStats = new RecentGameStats(this.summonerId,region);
    }

    public Sapp(String summoner_name) {
        this(summoner_name, "euw");
    }

    private String getSummonerId(String summoner_name, String region) {
        return null;
    }

    @Override
    public String toString(){
        return this.summoner_name;
    }
}
