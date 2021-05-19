package Model;

import java.util.List;

public class GK extends Player {
    private int elasticity;
    private int reflexes;
    private int agility;
    private int decisions;
    private final Position curPosition = Position.GOALKEEPER;

    /**
     * Empty Constructor
     */
    public GK() {
        super();
        this.elasticity = 0;
        this.reflexes = 0;
        this.agility = 0;
        this.decisions = 0;
    }

    /**
     * Constructor with player ID, name and current team name
     * @param id
     * @param name
     * @param currentTeam
     */
    public GK(String id, String name, String currentTeam) {
        super(id, name, currentTeam, Position.GOALKEEPER);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name and historic
     * @param id
     * @param name
     * @param currentTeam
     * @param historic
     */
    public GK(String id, String name, String currentTeam, List<String> historic) {
        super(id, name, currentTeam, historic, Position.GOALKEEPER);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player
     * @param p Player
     */
    public GK(Player p) {
        super(p);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team, historic and attributes
     * @param id
     * @param name
     * @param currentTeam
     * @param historic
     * @param elasticity
     * @param reflexes
     * @param agility
     * @param decisions
     */
    public GK(String id, String name, String currentTeam, List<String> historic, int elasticity, int reflexes, int agility, int decisions) {
        super(id, name, currentTeam, historic, Position.GOALKEEPER);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team and attributes
     * @param id
     * @param name
     * @param currentTeam
     * @param elasticity
     * @param reflexes
     * @param agility
     * @param decisions
     */
    public GK(String id, String name, String currentTeam, int elasticity, int reflexes, int agility, int decisions) {
        super(id, name, currentTeam, Position.GOALKEEPER);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player and attributes
     * @param p
     * @param elasticity
     * @param reflexes
     * @param agility
     * @param decisions
     */
    public GK(Player p, int elasticity, int reflexes, int agility, int decisions) {
        super(p);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    /**
     * Copy constructor
     * @param gk Goalkeeper to copy
     */
    public GK(GK gk){
        super(gk.getId(), gk.getName(), gk.getCurrentTeamName(), gk.getHistoric(), gk.getPosition());
        this.setElasticity(gk.getElasticity());
        this.setReflexes(gk.getReflexes());
        this.setAgility(gk.getAgility());
        this.setDecisions(gk.getDecisions());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned Goalkeeper
     */
    public GK clone(){
        return new GK(this);
    }

    /**
     * Elasticity getter
     * @return Player elasticity
     */
    public int getElasticity() {
        return this.elasticity;
    }

    /**
     * Elasticity setter
     * @param elasticity Elasticity to set
     */
    public void setElasticity(int elasticity) {
        if(elasticity > 99) this.elasticity = 99;
        else this.elasticity = Math.max(elasticity, 0);
    }

    /**
     * Reflexes getter
     * @return Player reflexes
     */
    public int getReflexes() {
        return this.reflexes;
    }

    /**
     * Reflexes setter
     * @param reflexes Reflexes to set
     */
    public void setReflexes(int reflexes) {
        if(reflexes > 99) this.reflexes = 99;
        else this.reflexes = Math.max(reflexes, 0);
    }

    /**
     * Agility getter
     * @return Player Agility
     */
    public int getAgility() {
        return this.agility;
    }

    /**
     * Agility setter
     * @param agility Agility to set
     */
    public void setAgility(int agility) {
        if(agility > 99) this.agility = 99;
        else this.agility = Math.max(agility, 0);
    }

    /**
     * Decisions getter
     * @return Player decisions
     */
    public int getDecisions() {
        return this.decisions;
    }

    /**
     * Decisions setter
     * @param decisions Decisions to set
     */
    public void setDecisions(int decisions) {
        if(decisions > 99) this.decisions = 99;
        else this.decisions = Math.max(decisions, 0);
    }

    /**
     * Current player position getter
     * @return Current player position
     */
    public Position getCurPosition() {
        return this.curPosition;
    }

    /**
     * Method to calculate player overall playing as goalkeeper
     * @return Player overall playing as goalkeeper
     */
    public int calcOverall(){
        return (int) (this.elasticity * 0.25 + this.reflexes * 0.25 + this.agility * 0.25 + this.decisions * 0.25);
    }

    /**
     * Method to get Goalkeeper as a String
     * @return Goalkeeper as a String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Goalkeeper\n");
        return sb.toString();
    }

}
