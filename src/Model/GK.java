package Model;

import java.util.List;

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
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
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
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
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
        this.velocity = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.courage = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    public GK(String id, String name, int number, String currentTeamName, int elasticity, int reflexes, int agility, int decisions, int velocity, int passing, int courage, int endurance) {
        super(id, name, number, currentTeamName, Position.GOALKEEPER);
        this.elasticity = elasticity;
        this.reflexes = reflexes;
        this.agility = agility;
        this.decisions = decisions;
        this.velocity = velocity;
        this.passing = passing;
        this.courage = courage;
        this.endurance = endurance;
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
        this.velocity = velocity;
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
        this.passing = passing;
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
        this.courage = courage;
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
        this.endurance = endurance;
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
        switch (attribute)
        {
            case 1:
                this.setElasticity(newValue);
                this.calcOverall();
                break;

            case 2:
                this.setReflexes(newValue);
                this.calcOverall();
                break;

            case 3:
                this.setAgility(newValue);
                this.calcOverall();
                break;

            case 4:
                this.setDecisions(newValue);
                this.calcOverall();
                break;
            case 5:
                this.setVelocity(newValue);
                this.calcOverall();
                break;
            case 6:
                this.setPassing(newValue);
                this.calcOverall();
                break;
            case 7:
                this.setCourage(newValue);
                this.calcOverall();
                break;
            case 8:
                this.setEndurance(newValue);
                this.calcOverall();
                break;

            default:
                throw new InvalidAttributeException("The attribute you inserted doesn't exist.");
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
