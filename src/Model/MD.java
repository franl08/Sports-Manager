package Model;

import java.util.List;

public class MD extends FieldPlayer{
    private final Position curPosition = Position.MIDFIELDER;

    /**
     * Empty Constructor
     */
    public MD() {
        super();
        super.setOverall(calcOverall());
    }

    /**
     * Construct with Field Player
     * @param p Field Player
     */
    public MD(FieldPlayer p) {
        super(p);
        super.setPosition(p.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name and historic
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param historic Player historic
     */
    public MD(String id, String name, String currentTeam, List<String> historic) {
        super(id, name, currentTeam, historic);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name and current team name
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     */
    public MD(String id, String name, String currentTeam) {
        super(id, name, currentTeam);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player, attributes and position
     * @param p Player
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public MD(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name, historic, attributes and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team
     * @param historic Player historic
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public MD(String id, String name, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name, attributes and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public MD(String id, String name, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Copy constructor
     * @param m Midfielder to copy
     */
    public MD(MD m){
        super(m.getId(), m.getName(), m.getCurrentTeamName(), m.getHistoric(), m.getVelocity(), m.getEndurance(), m.getSkill(), m.getImpulsion(), m.getHeading(), m.getFinishing(), m.getPassing(), m.getCrossing(), m.getBallRecovery(), m.getPositioning(), m.getCreativity(), m.getAggressiveness(), m.getTackling(), m.getVision(), m.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned midfielder
     */
    public MD clone(){
        return new MD(this);
    }

    /**
     * Method to calculate player overall playing as midfielder
     * @return Player overall playing as midfielder
     */
    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.WINGER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else
            newPositioning = (int) (this.getPositioning() * 0.5);

        return (int) ((this.getTackling() * 0.03) + (this.getAggressiveness() * 0.02) + (this.getCreativity() * 0.08) +
                (this.getFinishing() * 0.03) + (this.getCrossing() * 0.02) + (this.getBallRecovery() * 0.2) +
                (newPositioning * 0.14) + (this.getVision() * 0.11) + (this.getPassing() * 0.13) +
                (this.getHeading() * 0.01) + (this.getImpulsion() * 0.01) + (this.getSkill() * 0.08) +
                (this.getEndurance() * 0.06) + (this.getVelocity() * 0.06));
    }

    /**
     * Current player position getter
     * @return Current player position
     */
    public Position getCurPosition(){
        return this.curPosition;
    }

    /**
     * Method to get Midfielder as String
     * @return Midfielder as String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Miedfielder\n");
        return sb.toString();
    }
}
