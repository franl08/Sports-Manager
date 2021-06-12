package Model;

import java.util.List;

/**
 * Goalkeepers class
 */
public class GK extends Player {
    private int elasticity;
    private int reflexes;
    private int agility;
    private int decisions;
    private int velocity;
    private int passing;
    private int courage;
    private int endurance;
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
     * Constructor with player
     * @param p Player
     */
    public GK(Player p) {
        super(p);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        super.setOverall(calcOverall());
        this.setPosition(curPosition);
    }

    /**
     * Constructor with goalkeeper's name, number, current team name and historic
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     * @param currentTeam Goalkeeper's current team name
     * @param historic Goalkeeper's historic
     */
    public GK(String name, int number, String currentTeam, List<String> historic) {
        super(name, number, currentTeam, historic, Position.GOALKEEPER);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player name, number and current team name
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     * @param currentTeam Goalkeeper's current team name
     */
    public GK(String name, int number, String currentTeam) {
        super(name, number, currentTeam, Position.GOALKEEPER);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with goalkeeper's name and number
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     */
    public GK(String name, int number){
        super(name, number, Position.GOALKEEPER);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with goalkeeper's name, number, current team name and attributes
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     * @param currentTeamName Goalkeeper's current team name
     * @param elasticity Goalkeeper's elasticity
     * @param reflexes Goalkeeper's reflexes
     * @param agility Goalkeeper's agility
     * @param decisions Goalkeeper's decisions
     * @param velocity Goalkeeper's velocity
     * @param passing Goalkeeper's passing
     * @param courage Goalkeeper's courage
     * @param endurance Goalkeeper's endurance
     */
    public GK(String name, int number, String currentTeamName, int elasticity, int reflexes, int agility, int decisions, int velocity, int passing, int courage, int endurance) {
        super(name, number, currentTeamName, Position.GOALKEEPER);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        this.setVelocity(velocity);
        this.setPassing(passing);
        this.setCourage(courage);
        this.setEndurance(endurance);
    }

    /**
     * Parametrized constructor
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     * @param currentTeamName Goalkeeper's current team name
     * @param historic Goalkeeper's historic
     * @param elasticity Goalkeeper's elasticity
     * @param reflexes Goalkeeper's reflexes
     * @param agility Goalkeeper's agility
     * @param decisions Goalkeeper's decisions
     * @param velocity Goalkeeper's velocity
     * @param passing Goalkeeper's passing
     * @param courage Goalkeeper's courage
     * @param endurance Goalkeeper's endurance
     */
    public GK(String name, int number, String currentTeamName, List<String> historic, int elasticity, int reflexes, int agility, int decisions, int velocity, int passing, int courage, int endurance) {
        super(name, number, currentTeamName, historic, Position.GOALKEEPER);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        this.setVelocity(velocity);
        this.setPassing(passing);
        this.setCourage(courage);
        this.setEndurance(endurance);
    }

    /**
     * Constructor for logs
     * @param name Goalkeeper's name
     * @param number Goalkeeper's number
     * @param elasticity Goalkeeper's elasticity
     * @param reflexes Goalkeeper's reflexes
     * @param agility Goalkeeper's agility
     * @param decisions Goalkeeper's decisions
     * @param velocity Goalkeeper's velocity
     * @param passing Goalkeeper's passing
     * @param courage Goalkeeper's courage
     * @param endurance Goalkeeper's endurance
     */
    public GK(String name, int number, int elasticity, int reflexes, int agility, int decisions, int velocity, int passing, int courage, int endurance) {
        super(name, number, Position.GOALKEEPER);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        this.setVelocity(velocity);
        this.setPassing(passing);
        this.setCourage(courage);
        this.setEndurance(endurance);
    }

    /**
     * Copy constructor
     * @param gk Goalkeeper to copy
     */
    public GK(GK gk){
        super(gk.getName(), gk.getNumber(), gk.getCurrentTeamName(), gk.getHistoric(), gk.getPosition());
        this.setElasticity(gk.getElasticity());
        this.setReflexes(gk.getReflexes());
        this.setAgility(gk.getAgility());
        this.setDecisions(gk.getDecisions());
        this.setVelocity(gk.getVelocity());
        this.setPassing(gk.getPassing());
        this.setCourage(gk.getCourage());
        this.setEndurance(gk.getEndurance());
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
     * Velocity getter
     * @return Player velocity
     */
    public int getVelocity() {
        return this.velocity;
    }

    /**
     * Velocity Setter
     * @param velocity Velocity to set
     */
    public void setVelocity(int velocity) {
        if(velocity > 99) this.velocity = 99;
        else this.velocity = Math.max(velocity, 0);
    }

    /**
     * Passing getter
     * @return Player passing
     */
    public int getPassing() {
        return this.passing;
    }

    /**
     * Passing setter
     * @param passing Passing to set
     */
    public void setPassing(int passing) {
        if(passing > 99) this.passing = 99;
        else this.passing = Math.max(passing, 0);
    }

    /**
     * Courage getter
     * @return Player's courage
     */
    public int getCourage() {
        return this.courage;
    }

    /**
     * Courage Setter
     * @param courage Courage to set
     */
    public void setCourage(int courage) {
        if(courage > 99) this.courage = 99;
        else this.courage = Math.max(courage, 0);
    }

    /**
     * Endurance Getter
     * @return Player's endurance
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Endurance Setter
     * @param endurance Endurance to set
     */
    public void setEndurance(int endurance) {
        if(endurance > 99) this.endurance = 99;
        else this.endurance = Math.max(endurance, 0);
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
        return (int) (this.elasticity * 0.15 + this.reflexes * 0.15 + this.agility * 0.15 + this.decisions * 0.15 + this.velocity * 0.10
         + this.passing * 0.10 + this.courage * 0.10 + this.endurance * 0.10);
    }

    /**
     * Updates an attribute to a new value
     * @param attribute Attribute signature
     * @param newValue New value
     */
    public void updateAttribute(int attribute, int newValue) throws InvalidAttributeException
    {
        switch (attribute) {
            case 1 -> {
                this.setElasticity(newValue);
                this.calcOverall();
            }
            case 2 -> {
                this.setReflexes(newValue);
                this.calcOverall();
            }
            case 3 -> {
                this.setAgility(newValue);
                this.calcOverall();
            }
            case 4 -> {
                this.setDecisions(newValue);
                this.calcOverall();
            }
            case 5 -> {
                this.setVelocity(newValue);
                this.calcOverall();
            }
            case 6 -> {
                this.setPassing(newValue);
                this.calcOverall();
            }
            case 7 -> {
                this.setCourage(newValue);
                this.calcOverall();
            }
            case 8 -> {
                this.setEndurance(newValue);
                this.calcOverall();
            }
            default -> throw new InvalidAttributeException("The attribute you inserted doesn't exist.");
        }
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
