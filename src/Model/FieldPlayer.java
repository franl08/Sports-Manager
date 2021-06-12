package Model;

import java.util.List;

/**
 * Field Players class
 */
public abstract class FieldPlayer extends Player {
    /**
     * Player's velocity
     */
    private int velocity;
    /**
     * Player's endurance
     */
    private int endurance;
    /**
     * Player's skill
     */
    private int skill;
    /**
     * Player's impulsion
     */
    private int impulsion;
    /**
     * Player's heading
     */
    private int heading;
    /**
     * Player's finishing
     */
    private int finishing;
    /**
     * Player's passing
     */
    private int passing;
    /**
     * Player's crossing
     */
    private int crossing;
    /**
     * Player's ball recovery
     */
    private int ballRecovery;
    /**
     * Player's positioning
     */
    private int positioning;
    /**
     * Player's creativity
     */
    private int creativity;
    /**
     * Player's aggressiveness
     */
    private int aggressiveness;
    /**
     * Player's tackling
     */
    private int tackling;
    /**
     * Player's vision
     */
    private int vision;

    /**
     * Empty Constructor
     */
    public FieldPlayer() {
        super();
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor with Player
     * @param p Player
     */
    public FieldPlayer(Player p) {
        super(p);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor with name, number, current team name and historic
     * @param name Player's name
     * @param number Player's number
     * @param currentTeam Player's current team name
     * @param historic Player's historic
     */
    public FieldPlayer(String name, int number, String currentTeam, List<String> historic) {
        super(name, number, currentTeam, historic, null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor with player's name, player's number and player's current team name
     * @param name Player's name
     * @param number Player's number
     * @param currentTeam Player's current team name
     */
    public FieldPlayer(String name, int number, String currentTeam) {
        super(name, number, currentTeam, null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor with player's name and number
     * @param name Player's name
     * @param number Player's number
     */
    public FieldPlayer(String name, int number) {
        super(name, number,null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor with player, player's attributes and position
     * @param p Player
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param crossing Player's crossing
     * @param ballRecovery Player's ball recovery
     * @param positioning Player's positioning
     * @param creativity Player's creativity
     * @param aggressiveness Player's aggressiveness
     * @param tackling Player's tackling
     * @param vision Player's vision
     * @param position Player's position
     */
    public FieldPlayer(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);

    }

    /**
     * Parametrized constructor
     * @param name Player's name
     * @param number Player's number
     * @param currentTeam Player's current team
     * @param historic Player's historic
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param crossing Player's crossing
     * @param ballRecovery Player's ball recovery
     * @param positioning Player's positioning
     * @param creativity Player's creativity
     * @param aggressiveness Player's aggressiveness
     * @param tackling Player's tackling
     * @param vision Player's vision
     * @param position Player's position
     */
    public FieldPlayer(String name, int number, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, historic, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }

    /**
     * Constructor with player's name, number, currentTeam, attributes and position
     * @param name Player's name
     * @param number Player's number
     * @param currentTeam Player's current team
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param crossing Player's crossing
     * @param ballRecovery Player's ball recovery
     * @param positioning Player's positioning
     * @param creativity Player's creativity
     * @param aggressiveness Player's aggressiveness
     * @param tackling Player's tackling
     * @param vision Player's vision
     * @param position Player's position
     */
    public FieldPlayer(String name, int number, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }

    /**
     * Constructor with player's name, number, attributes and position
     * @param name Player's name
     * @param number Player's number
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param crossing Player's crossing
     * @param ballRecovery Player's ball recovery
     * @param positioning Player's positioning
     * @param creativity Player's creativity
     * @param aggressiveness Player's aggressiveness
     * @param tackling Player's tackling
     * @param vision Player's vision
     * @param position Player's position
     */
    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }

    /**
     * Constructor for Midfielders and Defenders of logs
     * @param name Player's name
     * @param number Player's number
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param crossing Player's crossing
     * @param position Player's position
     */
    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Constructor for Wingers and Forwards of logs
     * @param name Player's name
     * @param number Player's number
     * @param velocity Player's velocity
     * @param endurance Player's endurance
     * @param skill Player's skill
     * @param impulsion Player's impulsion
     * @param heading Player's heading
     * @param finishing Player's finishing
     * @param passing Player's passing
     * @param position Player's position
     */
    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    /**
     * Copy constructor
     * @param fp Player to copy
     */
    public FieldPlayer(FieldPlayer fp){
        super(fp.getName(), fp.getNumber(), fp.getCurrentTeamName(), fp.getHistoric(), fp.getCurPosition());
        this.setVelocity(fp.getVelocity());
        this.setEndurance(fp.getEndurance());
        this.setSkill(fp.getSkill());
        this.setImpulsion(fp.getImpulsion());
        this.setHeading(fp.getHeading());
        this.setFinishing(fp.getFinishing());
        this.setPassing(fp.getPassing());
        this.setCrossing(fp.getCrossing());
        this.setBallRecovery(fp.getBallRecovery());
        this.setPositioning(fp.getPositioning());
        this.setCreativity(fp.getCreativity());
        this.setAggressiveness(fp.getAggressiveness());
        this.setTackling(fp.getTackling());
        this.setVision(fp.getVision());
    }

    /**
     * Cloning method
     * @return Cloned FieldPlayer
     */
    public abstract FieldPlayer clone();

    /**
     * Abstract method to calculate player's overall
     * @return Player's overall
     */
    public abstract int calcOverall();

    /**
     * Abstract method to get Player's current position in a game
     * @return Player's overall
     */
    public abstract Position getCurPosition();

    /**
     * Velocity getter
     * @return Player's velocity
     */
    public int getVelocity() {
        return this.velocity;
    }

    /**
     * Velocity setter
     * @param velocity Velocity to set
     */
    public void setVelocity(int velocity) {
        if(velocity > 99) this.velocity = 99;
        else this.velocity = Math.max(velocity, 0);
    }

    /**
     * Endurance getter
     * @return Player's endurance
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Endurance setter
     * @param endurance Endurance to set
     */
    public void setEndurance(int endurance) {
        if(endurance > 99) this.endurance = 99;
        else this.endurance = Math.max(endurance, 0);
    }

    /**
     * Skill getter
     * @return Player's skill
     */
    public int getSkill() {
        return this.skill;
    }

    /**
     * Skill setter
     * @param skill Skill to set
     */
    public void setSkill(int skill) {
        if(skill > 99) this.skill = 99;
        else this.skill = Math.max(skill, 0);
    }

    /**
     * Impulsion getter
     * @return Player's impulsion
     */
    public int getImpulsion() {
        return this.impulsion;
    }

    /**
     * Impulsion setter
     * @param impulsion Impulsion to set
     */
    public void setImpulsion(int impulsion) {
        if(impulsion > 99) this.impulsion = 99;
        else this.impulsion = Math.max(impulsion, 0);
    }

    /**
     * Heading getter
     * @return Player's heading
     */
    public int getHeading() {
        return this.heading;
    }

    /**
     * Heading setter
     * @param heading Heading to setter
     */
    public void setHeading(int heading) {
        if(heading > 99) this.heading = 99;
        else this.heading = Math.max(heading, 0);
    }

    /**
     * Finishing getter
     * @return Player's finishing
     */
    public int getFinishing() {
        return this.finishing;
    }

    /**
     * Finishing setter
     * @param finishing Finishing to set
     */
    public void setFinishing(int finishing) {
        if(finishing > 99) this.finishing = 99;
        else this.finishing = Math.max(finishing, 0);
    }

    /**
     * Passing getter
     * @return Player's passing
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
     * Crossing getter
     * @return Player's crossing
     */
    public int getCrossing() {
        return this.crossing;
    }

    /**
     * Crossing setter
     * @param crossing Crossing to set
     */
    public void setCrossing(int crossing) {
        if(crossing > 99) this.crossing = 99;
        else this.crossing = Math.max(crossing, 0);
    }

    /**
     * Ball recovery getter
     * @return Player's ball recovery
     */
    public int getBallRecovery() {
        return this.ballRecovery;
    }

    /**
     * Ball recovery setter
     * @param ballRecovery Ball recovery to set
     */
    public void setBallRecovery(int ballRecovery) {
        if(ballRecovery > 99) this.ballRecovery = 99;
        else this.ballRecovery = Math.max(ballRecovery, 0);
    }

    /**
     * Positioning getter
     * @return Player's positioning
     */
    public int getPositioning() {
        return this.positioning;
    }

    /**
     * Positioning setter
     * @param positioning Positioning to set
     */
    public void setPositioning(int positioning) {
        if(positioning > 99) this.positioning = 99;
        else this.positioning = Math.max(positioning, 0);
    }

    /**
     * Creativity getter
     * @return Player's creativity
     */
    public int getCreativity() {
        return this.creativity;
    }

    /**
     * Creativity setter
     * @param creativity Creativity to set
     */
    public void setCreativity(int creativity) {
        if(creativity > 99) this.creativity = 99;
        else this.creativity = Math.max(creativity, 0);
    }

    /**
     * Aggressiveness getter
     * @return Player's aggressiveness
     */
    public int getAggressiveness() {
        return this.aggressiveness;
    }

    /**
     * Aggressiveness setter
     * @param aggressiveness Aggressiveness to set
     */
    public void setAggressiveness(int aggressiveness) {
        if(aggressiveness > 99) this.aggressiveness = 99;
        else this.aggressiveness = Math.max(aggressiveness, 0);
    }

    /**
     * Tackling getter
     * @return Player's tackling
     */
    public int getTackling() {
        return this.tackling;
    }

    /**
     * Tackling setter
     * @param tackling Tackling to set
     */
    public void setTackling(int tackling) {
        if(tackling > 99) this.tackling = 99;
        else this.tackling = Math.max(tackling, 0);
    }

    /**
     * Vision getter
     * @return Player's vision
     */
    public int getVision() {
        return this.vision;
    }

    /**
     * Vision setter
     * @param vision Vision to set
     */
    public void setVision(int vision) {
        if(vision > 99) this.vision = 99;
        else this.vision = Math.max(vision, 0);
    }

    /**
     * toString method
     * @return Player in String
     */
    public String toString(){
        return super.toString();
    }
}
