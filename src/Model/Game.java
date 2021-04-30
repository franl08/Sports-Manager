package Model;

import java.util.Set;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Player homeGK;
    private Player awayGK;
    private Set<DF> homeDFs;
    private Set<DF> awayDFs;
    private Set<MD> homeMDs;
    private Set<MD> awayMDs;
    private Set<WG> homeWGs;
    private Set<WG> awayWGs;
    private Set<FW> homeFWs;
    private Set<FW> awayFWs;
    private int homeGoals;
    private int awayGoals;
    private int homeSubstitutions;
    private int awaySubstitutions;
}
